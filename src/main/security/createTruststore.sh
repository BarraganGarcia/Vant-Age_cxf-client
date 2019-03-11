#!/bin/sh
export CLIENT=
export THIRD_PART_CERTIFICATE=
export TRUSTSTORE_FILE=truststore.jks
export TRUSTSTORE_PASSWORD=
export KEY_PASSWORD=
export ALIAS=${CLIENT}
#Genera un truststore con un par de llaves dummy.
keytool -genkey -alias dummy -keyalg RSA -keysize 2048 -keystore ${TRUSTSTORE_FILE} -dname "CN=dummy, OU=, O=, L=, S=, C=" -storepass ${TRUSTSTORE_PASSWORD} -keypass ${KEY_PASSWORD}
#Lista el contenido del truststore.
keytool -list -keystore ${TRUSTSTORE_FILE} -storepass ${TRUSTSTORE_PASSWORD}
#Elimina el par de llaves dummy.
keytool -delete -alias dummy -keystore ${TRUSTSTORE_FILE} -storepass ${TRUSTSTORE_PASSWORD}
#Agrega el certificado al truststore.
keytool -import -file ${THIRD_PART_CERTIFICATE} -keystore ${TRUSTSTORE_FILE} -storepass ${TRUSTSTORE_PASSWORD} -noprompt -alias ${ALIAS}
#Lista el contenido del truststore.
keytool -list -keystore ${TRUSTSTORE_FILE} -storepass ${TRUSTSTORE_PASSWORD}
#Borra todos los archivos excepto el truststore.
rm -rf ${THIRD_PART_CERTIFICATE}
