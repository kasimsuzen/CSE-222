from random import randint

content = []
with open("NAME") as f:
    content = f.readlines()

f = open("part2.txt","w")
f.write("Name    Student Card    Academic Card\n")

counter = 521

tempString = ""
randomNumber = 0
for i in content:
	randomNumber = randint(0,100)
	if randomNumber > 80:
		tempString = i.strip("\n") + "    " + str(counter) + "    " + str(counter+5000) + "\n"
	else:
		tempString = i.strip("\n") + "    " + "yok" + "    " + str(counter+5000) + "\n"
	counter = counter + 1
	f.write(tempString)