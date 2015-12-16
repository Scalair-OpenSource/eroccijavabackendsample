#! /bin/sh
#
# Generated at Wed Dec 16 15:18:12 CET 2015 from platform:/resource/fr.scalair.occi.test/My.occic by org.occiware.clouddesigner.occi.gen.curl
#

OCCI_SERVER_URL=http://localhost:8080
CURL_OPTS="-s -v -i"

curl $CURL_OPTS -X PUT $OCCI_SERVER_URL/storage/r1 -H 'Content-Type: text/occi' \
    -H 'Category: storage; scheme="http://schemas.ogf.org/occi/infrastructure#"; class="kind", StorageType; scheme="http://scalair.fr/occi#"; class="mixin";' -H 'X-OCCI-Attribute: occi.storage.size=10' -H 'X-OCCI-Attribute: type="ssd"'
