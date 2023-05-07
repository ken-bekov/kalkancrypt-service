#!/bin/bash
mvn install:install-file -Dfile=libs/kalkancrypt-0.7.2.jar -DgroupId=kz.egov -DartifactId=kalkancrypt -Dversion=0.7.2 -Dpackaging=jar
mvn install:install-file -Dfile=libs/knca_provider_util-0.8.jar -DgroupId=kz.egov -DartifactId=kalkancrypt_util -Dversion=0.8 -Dpackaging=jar