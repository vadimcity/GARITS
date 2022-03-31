#!/bin/sh
rm $PWD/backups/$1
sed -i "/$1/d" $PWD/backups/restore-point.txt
echo "Deleted restore point $1"

