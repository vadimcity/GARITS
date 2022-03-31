#!/bin/sh
date_var=$(date +"%m-%d-%Y-%T")
mysqldump --host=192.168.0.10 -P 3308 -u $1 -p$2 t18database > $PWD/backups/dbbackup-$date_var.sql
RESULT=$?
if [ $RESULT == 0 ]; then 
	echo "Back up Date: $date_var has been made."
	echo "dbbackup-$date_var.sql" >> $PWD/backups/restore-point.txt
else
	echo "Back up failed. Check Username and Password."
	rm $PWD/backups/dbbackup-$date_var.sql
fi
