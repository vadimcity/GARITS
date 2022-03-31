ping -c 1 -w 1 192.168.0.10 > /dev/null
RESULT=$?
if [ $RESULT == 1 ]; then 
        echo "No connection to database. Only deleting local restore points is available."
        exit
fi
