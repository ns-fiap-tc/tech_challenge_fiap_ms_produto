# AWS provider configuration
variable "aws_region" {
  description = "AWS region"
  type        = string
  default     = "us-east-1"
}

# Database produto configuration
variable "db_produto_username" {
  description = "The username for the RDS produto instance"
  type        = string
  sensitive   = true
}

variable "db_produto_password" {
  description = "The password for the RDS produto instance"
  type        = string
  sensitive   = true
}

variable "db_produto_name" {
  description = "Database produto name"
  type        = string
  default     = "lanch_cat_db"
}

variable "db_produto_port" {
  description = "Database produto port"
  type        = string
  default     = "5432"
}

variable "db_produto_identifier" {
  description = "The identifier for the RDS produto instance"
  type        = string
  default     = "lanchonete-produto-db"
}

#Variaveis DockerHUB

variable "dockerhub_username" {
  description = "The username of the dockerhub image to deploy"
  type        = string
}

/*variable "dockerhub_token" {
  description = "The access token of the dockerhub image to deploy"
  type        = string
}*/