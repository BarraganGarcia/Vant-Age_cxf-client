# Vant-Age_cxf-client

1.- Crea el archivo pri_key.pem en el directorio: src/main/security y agrega tu llave privada sin cifrar.

2.- Modifica el archivo pom.xml y define las variables de profile: keystore.password y key.password

3.- Edita el archivo src/main/securiy/createKeystore.sh y define las variables: KEYSTORE_PASSWORD y KEY_PASSWORD

4.- Añade permisos de ejecución al archivo src/main/securiy/createKeystore.sh y ejecútalo.

5.- Desde raíz, mismo directorio donde está el archivo pom.xml ejecuta: mvn -PQA clean package
