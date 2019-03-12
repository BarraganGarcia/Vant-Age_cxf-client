# Vant-Age_cxf-client

1.- Modifica el archivo pom.xml y define las variables del profile QA: keystore.password, privatekey.alias, privatekey.password, truststore.password, publickey.alias

2.- Edita el archivo src/main/securiy/createKeystore.sh y define las variables: CLIENT(privatekey.alias), KEYSTORE_PASSWORD(keystore.password) y KEY_PASSWORD(privatekey.password)

3.- Añade permisos de ejecución al archivo src/main/securiy/createKeystore.sh y ejecútalo

4.- Fírmate al Portal de Desarrolladores API Hub de Círculo de Crédito

5.- Registra tu aplicación y carga tu certificado (certificate.pem)

6.- Descarga el certificado que generará API HUB para tu aplicación y cópialo en el directorio src/main/security

7.- Edita el archivo src/main/security/createTruststore.sh y define las variables: THIRD_PART_CERTIFICATE (nombre del certificado que descargaste), TRUSTSTORE_PASSWORD(truststore.password) y KEY_PASSWORD(publickey.alias)

8.- Añade permisos de ejecución al archivo src/main/securiy/createTruststore.sh y ejecútalo

9.- Modifica los datos de entrada de la clase: SegmentadorApiTest 

10.- Desde raíz, mismo directorio donde está el archivo pom.xml ejecuta: mvn -PQA clean package