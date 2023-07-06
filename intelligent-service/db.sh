#!/bin/bash
printf "CREATE SCHEMA IF NOT EXISTS customer;\nCREATE SCHEMA IF NOT EXISTS maintenance;" > init.sql
psql -U loga loga -f init.sql
