data "aws_db_instance" "lanchonete_produto_db" {
  db_instance_identifier = var.db_produto_identifier
}

data "aws_eks_cluster" "lanchonete_cluster" {
  name = "lanchonete_cluster"
}

data "aws_eks_cluster_auth" "lanchonete_cluster_auth" {
  name = data.aws_eks_cluster.lanchonete_cluster.name
}

