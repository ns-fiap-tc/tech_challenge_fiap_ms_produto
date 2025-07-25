resource "kubernetes_secret" "secrets-produto" {
  metadata {
    name = "secrets-produto"
  }

  type = "Opaque"

  data = {
    DB_HOST             = element(split(":",data.aws_db_instance.lanchonete_produto_db.endpoint),0)
    DB_PORT             = var.db_produto_port
    DB_NAME             = var.db_produto_name
    DB_USER             = var.db_produto_username
    DB_PASSWORD         = var.db_produto_password
  }

  lifecycle {
    prevent_destroy = false
  }
}

# MS PRODUTO 
resource "kubernetes_deployment" "deployment-ms-produto" {
  metadata {
    name      = "deployment-ms-produto"
    namespace = "default"
  }

  spec {
    selector {
      match_labels = {
        app = "deployment-ms-produto"
      }
    }

    template {
      metadata {
        labels = {
          app = "deployment-ms-produto"
        }
      }

      spec {
        toleration {
          key      = "key"
          operator = "Equal"
          value    = "value"
          effect   = "NoSchedule"
        }

        container {
          name  = "deployment-ms-produto-container"
          image = "${var.dockerhub_username}/fiap-tech-challenge-lanchonete-ms-produto:latest"

          resources {
            requests = {
              memory : "512Mi"
              cpu : "500m"
            }
            limits = {
              memory = "1Gi"
              cpu    = "1"
            }
          }

          env_from {
            secret_ref {
              name = kubernetes_secret.secrets-produto.metadata[0].name
            }
          }

          port {
            container_port = "8080"
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "service-ms-produto" {
  metadata {
    name      = "service-ms-produto"
    namespace = "default"
    annotations = {
      "service.beta.kubernetes.io/aws-load-balancer-type" : "nlb",
      "service.beta.kubernetes.io/aws-load-balancer-scheme" : "internal",
      "service.beta.kubernetes.io/aws-load-balancer-cross-zone-load-balancing-enabled" : "true"
    }
  }
  spec {
    selector = {
      app = "deployment-ms-produto"
    }
    port {
      port = "80"
      target_port = "8080"
      node_port = "30001"
    }
    type = "LoadBalancer"
  }
}
