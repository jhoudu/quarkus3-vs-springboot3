#!/usr/bin/env bash
bash -c 'while [[ "$(curl -s -o /dev/null -w ''%{http_code}'' localhost:8080/customers/Josh)" != "200" ]]; do sleep .00001; done'