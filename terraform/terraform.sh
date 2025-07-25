#!/bin/bash

# Carrega as variáveis do arquivo .env
if [ -f .env ]; then
    export $(grep -v '^#' .env | xargs)
else
    echo "[terraform] Erro: Arquivo .env não encontrado."
    exit 1
fi

# Verifica se o método foi passado como argumento
if [ -z "$1" ]; then
    echo "[terraform] Erro: Nenhum método especificado (plan, apply, etc.)."
    exit 1
fi

METHOD=$1
shift

PARAMS="$@"

terraform $METHOD $PARAMS \
-var "aws_region=$AWS_REGION" \
-var "db_produto_username=$DB_PRODUTO_USERNAME" \
-var "db_produto_password=$DB_PRODUTO_PASSWORD" \
-var "db_produto_identifier=$DB_PRODUTO_IDENTIFIER" \
-var "db_produto_name=$DB_PRODUTO_NAME" \
-var "db_produto_port=$DB_PRODUTO_PORT" \
-var "dockerhub_username=$DOCKERHUB_USERNAME"