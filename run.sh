user="Nekoemm"
pwd="a1725608358"
echo check git status ...
git status
echo "commit?(yes/no)"
read choice

if [ ${choice = y}]
then echo Please Enter the commit message:
else echo Not commited.
exit
fi

read message

git add .
git commit -m"$message"
echo committed
echo "push to git?(yes/no)"
read push_choice

if [ ${push_choice} =y ]
then echo trying to push to origin master...
