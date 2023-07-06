#!/bin/bash
printf "CREATE SCHEMA IF NOT EXISTS customers;\nCREATE SCHEMA IF NOT EXISTS maintenances;" > init.sql
psql -U loga-dwh loga-dwh -f init.sql
