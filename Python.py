# Python reference sheet.

# PYTHON IS A SCRIPTING LANGUAGE WITH OOP CAPABILITIES.
# Understand that all files are executed as a script, from top to bottom.
# See the class notes for more.

# Comments use hash.
# Appears to be no method of performing inline comments.



# Package namespaces are automatically inherited from directory,
# thus no package decleration is required like in java.

# importing whole namespace / package / class
import random



# Importing specific parts of a package / class

# from namespace import subpackage

# Doing this removes the requirement to specify the parenting class.
# so instead of random.randrange(),
# just use randrange().
from random import randrange
from typing import _Final




""" 
Python docs are known as 'docstring', between triple quotes.
Docstrings use "Sphinx" stylisation.

Docstring attributes.

Parameters:
	param1 (int): description of param1
	param2 (string): description of param2

Returns:
	int: description of return value

 	:param a: arg1
    :type  a: int

    :param b: arg2
    :type  b: int

    :param c: arg3, defaults to 0
    :type  c: int, optional

    :raises ValueError: if arg1 is equal to arg2
    
    :rtype: int
    :return: multiplication of all arguments 
"""



# Py scriptures do not require classes. Scripted files run from top to bottom.

# Python statements do not require an end statement symbol (;).
# Statements can be infered from lines,
# however ; may be used to mark multiple statements on the same line.
# statement; statement; statement

# Python object classification
class ClassName:
	# Class property
	ClassProperty = None



	# constructor with overload parameters.
	# Constructors MUST have a param for self.
	# self param is the current object reference, same as 'self' keyword.

	# constructors should be placed at the extreme base of the file.
	# methods and properties are parsed at runtime, from top to bottom.
	# All methods are defined one after another at runtime.
	# runtime should be allowed to parse the class before invoking __init__ last.

	# This same logic requires that functions are defined above
	# where they are required. This does not matter so much if nothing is invoked
	# untill the parser reaches the end of the file first.

	# this behaiour makes python able to be used as a scripting language, with
	# no classes or methods required. Class level statements are executed as the parser works
	# it's way to the bottom initially, so no invocation is even required. Just parse the file
	# to run a script.

	# further, this behavour allows statements that setup or prepare a class or it's properties
	# to be placed at class level, and executed before the parser reaches __init__.
	
	# Not sure why self param is required.
	# I believe it's for compatability:
	# Python had no automatic inheritence for instances, so 'self' keyword
	# couldn't exsist, so self parameter was automatically parsed by default.
	# Now, self keyword and full instance is implemented, but the param is kept for
	# compatability.
	def __init__(self, f, s):
		ClassProperty = ""





## Variables

# Inherited type
itterator = 0

# Final marker from typing packages.
# Closest python has to readonly or final.
# indicates to runtime to not allow modification, but does not
# prevent reassignment.
ITTERATE_TO: _Final = 100

# Declared type
epstienKilledHimself: bool

CORRECT_PASSWORD: _Final = "yeet"
password = CORRECT_PASSWORD

# Access modifyer

# python has no access modifyer.
# Underscores are standard as indication to other's of what is and isn't
# supposed to be used externally.



# no modifyer declared public access by default.
publicVariable = 1

# single underscore prefix declares protected.
# Only this class and sub classes may access.
_protectedVariable = 1

# double underscore declares private. For this class only.
__privateVariable = 1

# _X()
# Methods with a leading _ are automatically not imported
# when using a wildcard import,
# import x
# unless you specify
# from x import __all__

# X_
# Trailing underscores are to avoid ambiguity with keywords.
# class_ = myClass


# __X
# Double leading underscores cause the interpreter to entirely rewrite
# the attribute, assigning the name as if if weren't assigned yet.

# __X__
# invocations that are reserved for interpreter & python system.
# i.e __init__
# 	  __main__

# _
# temporary or insignificant variable.
# for _ in list:
# 	print(_)

# functions are lexed into memory like a script; therefore
# they must be defined before they are used. They can't invoked
# dynamically like in OOP languages.
def printgauss():
    print(gaussTotal)

# return and param types can be infered, and not declared.

# Default return type is 'None'
# For single statement functions, this format is valid.
def addOne(num): return num + 1

# Function with return type.
# Linter in vs code doesn't seem to understand these correctly.
#def greeting(name: str) -> str:
#  return 'Hello, {}'.format(name)


# flow control

# Code blocks are infered from indentation; thus correct indentation is required.
# A good linter will indicate invalid indentation. Builds will fail
# with bad indentation levels.

# Indented code blocks are prefaced by the statement it belongs to, followed by ':'.
# returning from indentation level automatically ends code block.
#
# parent statement:
# 	statement Block
# statement not in block.

# parenting if flow control
if password == CORRECT_PASSWORD: 
	# intented block belonging to if.
    print("yeet indeed")
# parenting else flow control
else:
	# indented block belonging to else.
	print("yeet indeed")

# parenting while flow control
# while condition:
while itterator < ITTERATE_TO:
    itterator = addOne(itterator);
    print("Jeffry epstien didn't kill himself")
    epstienKilledHimself = random.randint(0,100) >= 50
    if epstienKilledHimself:
		# break out of loop flow control
        break
    else:
		# skip rest of loop, and start from top. same as java.
        continue

# for = foreach.
# for itterates over an itterateable class.
# Itterateable classes have arrays of elements of a specified length.
# These may be custom lists, or using the range utility.
# range(length)
# range(start, stop, step)
# 
# range creates a sequence of integers which can be itterated over.
#
# for currentElement in itterateable:
# 	doThis
for i in range(ITTERATE_TO):
    print("beans" * i)

gaussTotal = 0
for i in range(ITTERATE_TO + 1):
    gaussTotal += i

# class level function call. Scripting feature.
printgauss()

# reassigning class variables is done same as creating them.
# OOP would assume this to be an attempt to create another variable of the same name, and wouldn't
# pass linting.
gaussTotal = 0
itterator = 0
while itterator < ITTERATE_TO + 1:
    gaussTotal += itterator
    itterator = addOne(itterator)

printgauss()

"""
and				A logical operator
as				To create an alias
assert			For debugging
break			To break out of a loop
class			To define a class
continue		To continue to the next iteration of a loop
def				To define a function
del				To delete an object
elif			Used in conditional statements, same as else if
else			Used in conditional statements
except			Used with exceptions, what to do when an exception occurs
False			Boolean value, result of comparison operations
finally			Used with exceptions, a block of code that will be executed no matter if there is an exception or not
for				To create a for loop
from			To import specific parts of a module
global			To declare a global variable
if				To make a conditional statement
import			To import a module
in				To check if a value is present in a list, tuple, etc.
is				To test if two variables are equal
lambda			To create an anonymous function
None			Represents a null value
nonlocal		To declare a non-local variable
not				A logical operator
or				A logical operator
pass			A null statement, a statement that will do nothing
raise			To raise an exception
return			To exit a function and return a value
True			Boolean value, result of comparison operations
try				To make a try...except statement
while			To create a while loop
with			Used to simplify exception handling
yield			To end a function, returns a generator
"""
