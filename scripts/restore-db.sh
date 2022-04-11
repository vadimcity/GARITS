#!/bin/sh
date_var=$(date +"%m-%d-%Y-%T")
mysql --host=192.168.0.10 -P 3308 -u $1 -p$2 t18database < $PWD/backups/$3
RESULT=$?
if [ $RESULT == 0 ]; then 
	echo "Restore: $date_var has been made."
else
	echo "Restore Failed."
	echo "Check Username and Password."
fi
