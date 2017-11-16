sudo docker build -t mysqloop .
sudo docker run --publish-all=true -p 3305:3306 -d -v "$(pwd)"/MySQL_Files:/var/lib/mysql mysqloop 
