#!/bin/bash

git config --global user.name "rocdane"
git config --global user.email "rocdanesabi@gmail.com"
git init
git add .
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/rocdane/tfe-master.git
git remote set-url origin git@github.com:rocdane/tfe-master.git
git push -u origin main

