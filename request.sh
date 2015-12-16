#!/usr/bin/env bash


echo '{ "resources":[ { "kind":"http://schemas.ogf.org/occi/infrastructure#storage", "attributes": { "occi.storage.size":1000000000, "occi.storage.state":"started" } }] }' \
 | curl -v -H 'content-type: application/json' -X POST --data-binary @- http://localhost:8080/collections/storage/