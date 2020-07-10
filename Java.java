// comment

/* inline */

/*
	comment
	block
*/

/**
 * JavaDocs title
 * 
 * Javadocs element description. Javadocs is the documentation standard for all java elements.
 * 
 * Notes to programmers
 * @apiNote		API sidenote
 * @implNote	Implementation note
 * @implSpec	Implementation specification (i.e custom requirements / rules)
 * 
 * @deprecated	This should no longer be used. May provide replacement, and version in which this will be removed.
 * @see			Look at this (Reference page, documentation, etc)
 * 
 * 
 * @serial		This element is serializable
 * @serialField "" field
 * @serialData	"" data
 * 
 * @since		Project version this was added
 * @version		Version of this element
 * @author		Creator of element.
 
 * 
 * @throws		ExceptionName. This can throw an exception in this condition.
 * @exception	exact same as @throws, but doesn't read as smoothly.
 * 
 * @hidden		Not sure, but it exsists.
 * 
 * @CustomTag   You can use any tag you like, 
 * 
 * Proposed by oracle.
 * @category	For logically grouping classes, methods, fields. May get shortedned to @cat.
 * @example  	Example usage of element
 * @tutorial	link to a tutorial. Essentially, @see.
 * @todo		For marking released material incomplete, or requiring work, with a description of work.
 * @internal	Holds note that's internal to the production company only.
 */

// Package level elements.
// Few things can be at package level in a java file.
// 1) package decleration
// 2) imports
// 3) object (Class, enum, interface, annotation)

// package
// Packages are intelligently infered from directory, but classes MUST declare themselves
// to be in the package with the first line in the FILE, NOT CLASS.
// i.e package com.shinkson47.playground.tools;

// imports
// To access other packages, they must be imported.
// IntelliJ and eclipse automatically handle and organise imports.

// Force organise (IntelliJ, Eclipse)
// Mac - Cmd ⌘ + Shift ⇧ + o
// PC  - Ctrl  + Shift ⇧ + o

// Force organise (VS Code)
// Mac - Option ⌥ + Shift ⇧ + o
// PC  - Alt      + Shift ⇧ + o

// Import all in package
import java.awt.event.KeyEvent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JOptionPane;

// classes in the same package level do not require importing.

/**
 * Java is OOP only, never scripted. (That's javascript!)
 *
 * Files must contain a class. A class defines an object. Every element must
 * belong to a class.
 * 
 * Entire classes are parsed into VM Class objects before they may be executed.
 * This means that class content can be typed and accessed in any order at class
 * level. Methods at the top of the class can reach methods below; unlike
 * python.
 * 
 */
class Java {

	// Blocks of multiple statements is defined by wrapping in {}.
	// Single statement blocks can be infered, i.e
	// if(true) doThis();

	// Statements MUST end with a semicolon(;). Even if there is only one on a line
	// because
	// Java is not a scripting language - it cares for statements, not lines. lines
	// =/= statements =/= an instruction

	// Java can have regions, similar to c#'s '#region', just written as comments.
	//#region example
	// IntelliJ and VS Code can fold (collapse) these regions with an arrow by the
	// line numbers. I presume eclipse can too.
	//#endregion

	/**
	 * Java class level property.
	 * 
	 * variables are defines in the format: type camelCaseTokenName (= value);
	 * 
	 * Note that in Java types are never infered. Types must be declared. Types are
	 * either objects (enum, class) or a raw data type (byte, float, int, etc)
	 * 
	 * Linter and build will fail on assignments incompatable by type
	 * 
	 * Try to always declare with an access modifyer, not like this.
	 */
	int classLevel = 1;

	/**
	 * private property. Only accessable in this class.
	 * 
	 * Linter will warn of private elements that are not used locally, since they
	 * can only be used here.
	 */
	private int privateClassLevel = 1;

	/**
	 * protected property Accessable anywhere within this library.
	 * 
	 * Once built, it will not be accessable by users.
	 */
	protected int protectedClassLevel = 1;

	/**
	 * public property publicly read and writable property.
	 * 
	 * Public variables should be avoided, unless they're supposed to be changed
	 * outside of this class. Otherwise use private members with getters and setters
	 * to controll read and write access.
	 * 
	 * IntelliJ, Eclipse and VS Code can all generate getters and setters
	 * automatically from context menu.
	 */
	public int publicClassLevel = 1;

	/**
	 * static property Always only one instance. Static should be PascalCasing not
	 * camelCasing
	 * 
	 * The above members are unique to each instance (copy) of this class that're
	 * created at runtime.
	 * 
	 * For example, a 'Ball' class; multiple balls may exsist will different
	 * properties each (weight, colour, etc)
	 * 
	 * A static member is free of instance. This member could be used to change or
	 * set a property for ALL balls, in this example.
	 */
	public static int StaticClassLevel = 1;

	/**
	 * final property Can never be changed. Set litterally only, can never be set
	 * dynamically. Commonly used publicly and statically to declare an unchangeable
	 * property about all instances of this class.
	 * 
	 * final's are written in caps, with '_' to replace spaces, LIKE_THIS This
	 * convention indicates to users that the value is final.
	 * 
	 * 
	 * For example, math.PI will never change, and is not unique to an instance of
	 * math. It will always be equal to pi.
	 * 
	 * 
	 * These can also be used to enumerate options or categories, whilst masking
	 * actual data. For example KetEvent staically contains final values for virtual
	 * key event ID's. This could be used to check key presses by key ID without
	 * ever needing to worry about the key's ID.
	 * 
	 * if (inputID == KeyEvent.VK_ENTER) EnterWasPressed();
	 */
	public static final int FINAL_CLASS_LEVEL = KeyEvent.VK_ENTER;

	/**
	 * Default constructor Will always be invoked upon a new instance of this class.
	 * Used to dynamically prepare and configure a new instance.
	 * 
	 * Can be class, public, protected. Never static; it's unique to each instance
	 * of this class. Can also be used to prevent creating instances of this class
	 * by defining it as private.
	 * 
	 * Has no return type, and a name which matches the class name. Automatically
	 * invoked upon "new Class()"; i.e Java myJava = new Java();
	 * 
	 * Can have parameters. Multiple constructors should call each other in a chain
	 * with default vaules to replace those not specified.
	 * 
	 * Entirely optional.
	 */
	public Java() {
		this(1);
	}

	public Java(int i) {
		this(1, 2);
	}

	public Java(int i, int j) {
		publicClassLevel = i;
		privateClassLevel = j;
	}

	/**
	 * Main Runtime entry method. Beginning of java execution. Must have string
	 * array param, contains command line program arguments. Always static.
	 * 
	 * Can be multiple in a namespace, but which to use must be delcared to the VM.
	 * (That's done automatically in IDE's by running from a specific file, or which
	 * run config is selected)
	 */
	public static void main(String[] args) {
		// Create a new instance of a class, with no variable stored reference to it.
		// Invokes constructor.
		new Java();
	}

	/**
	 * Method Methods are interactions with this object. Can have parameters, but
	 * return nothing. return statement is not required. Static should be
	 * PascalCasing not camelCasing
	 * 
	 * With instantiable objects, static methods are typically tools for all objects
	 * of this type, not an instance. Must have return type specified, no return is
	 * 'void'
	 * 
	 * linter will warn of private methods that are not used locally.
	 */
	private static void StaticMethod() {
		return;
	}

	/**
	 * Function Functions map an input to an output. Return type must not be void.
	 * Retrun statement is required to be reached, regardless of the path the code
	 * takes.
	 * 
	 * i.e if(true){ return this; } else { return this; }
	 * 
	 * OR
	 * 
	 * if (true){ do a thing } else { do a thing }
	 * 
	 * return result;
	 * 
	 * 
	 * 
	 */
	public static int StaticPlusOne(int input) {
		return input + 1;
	}

	/**
	 * Ternary operator (short 'if')
	 * 
	 * Extremely useful, return a value based on a condition. variable = condition ?
	 * valueIfMet : valueIfNotMet;
	 * 
	 * i.e getInput(){ return preferKeyboard ? keyboard : controller; }
	 */
	public static int TernaryFunction(int i) {
		return (i > 100) ? 0 : 1;
	}

	/**
	 * Flow control
	 */
	public static void FlowControl(boolean flow) {
		if (flow) { // IF
		} else if (flow) { // ELSE IF
		} else {
		} // ELSE

		if (flow)
			return; // Single statements can be inherited without {}

		while (flow) { // Whilst condition, repeat block.
			flow = false; // Condition must be changed to stop loop.
			continue; // Skip rest of this loop, and start next one.
			break; 	// Completely break free of while loop. Wont be reached, because of the continue
					// above it.
		}

		do {} while (flow);	// Essentially the exact same as while.

		// Itterates over an itterateable object, such as a list or array,
		// with the current item in i.
		// Used for completing a task to every item in a list, or searching for an item.
		for (Object i : new ArrayList()) {
			continue; // Skip the rest of this block
			break; 	// break out of for loop entirely. Wont be reached, because of the continue
					// above it.
		}

		// Error handling
		try {
			throw new CustomException("yeet");
		} // Try to complete a routine which can throws errors or exceptions.
		catch (OutOfMemoryError e) {
		} // Catch and handle specific exceptions
		catch (CustomException e) {
		} catch (Exception e) {
		} // Handle generic exception
		finally {
		} // Always executed after a tried routine, unconditionally.
	}

	/**
	 * sub class Classified object within a class.
	 * 
	 * Extends: is an extention of another class. extentions have everything in the
	 * super class and thier class. Super class can be accessed natively as if it
	 * were in the extended class, or directly with 'super' keyword.
	 * 
	 * extentions can also hide / replace inherited elements, thus keeping the same
	 * interface but replacing the behaviour.
	 * 
	 * 
	 * 
	 * Exceptions exceptions are a class with basic error information. All
	 * exceptions extend exception, and custom ones can be built for custom errors
	 * in custom routines.
	 */
	class CustomException extends Exception {
		// Exceptions are serializable, this declares compatability with serialized
		// versions of this class.
		private static final long serialVersionUID = 1L;

		/**
		 * Constructor
		 * 
		 * Custom exception stores a message just like a normal exception, but will also
		 * display it in a message box to the user automatically when the error occours.
		 * 
		 * @param customExceptionMessage message to store and display
		 */
		public CustomException(String customExceptionMessage) {
			super("Custom Exception:" + customExceptionMessage); // Parse message to constructor of super (extended
																	// exception class)
			JOptionPane.showMessageDialog(null, customExceptionMessage); // Display message in message dialog, with null
																			// parent.
		}
	}

	/**
	 * Enumerator enums are list of options which are selectable and comparable.
	 * enums replace the need to use final variables to declare options using ID's,
	 * id no id is needed (like KeyEvent.VK_..., see above.)
	 */
	enum customModes {
		Mode1, Mode2, Mode3, Mode4, NoMode
	}

	/**
	 * Current mode defaults to noMode
	 */
	public static customModes mode = customModes.NoMode;

	/**
	 * Annotations Annotations are meta data on methods, fields and classes for
	 * either runtime, build time or for editor the only.
	 * 
	 * Such as the inbuilt annotations @SuppressWarnings("warningName"), - Prevents
	 * warnings from this element. @Override, - This element overrides one of the
	 * same name in an extended class
	 * 
	 * @Depricated - This element is marked to not be used
	 */
	@Retention(RetentionPolicy.RUNTIME) // Intended for runtime,
	@Target(ElementType.METHOD) // and use on a method.
	public @interface customAnnotation {
		// Can have a constructor to take values, like those above.

		public boolean enabled = false; // Methods with this annotation will have an 'enable' boolean.
	} 									// Custom code could check this to see if the method is enabled,
	  									// or the method could use it to reject being called.
	// i.e
	@customAnnotation()
	public void annotationExample() {
		try {
			Method m = getClass().getMethod("annotationExample");			// Get this method
			customAnnotation a = m.getAnnotation(customAnnotation.class);	// Get annotation matching my type from method
			if (!a.enabled) return;											// If annotation not enabled, return.
		} catch (NoSuchMethodException | SecurityException e) {} 
	}


	 /**
	  * Keywords

	MODIFYERS
	abstract		-	Method with no definition. Must be contained within an abstract class. Cannot be used on vars. Sub classes must inherit.
	synchronized	-   Method or block aqquires mutex lock. Ensures that only one thread at a time can operate on an object. Lock is released when sync code block is exited.
	implements		- 	Specifies one or more interfaces used by a class.
	interface		-   Declares class to be an interface.
	extends			-	Class is an extention of another. Can only extend a single class, but extended classes can be chained.
	throws			- 	This method can throw a runtime exception. Required where throws are not caught.
	transient		- 	Declares element to not be a part of a serialized object.
	native			-   Method functionality is written in a different language, not this class. Can be used to interface system calls, or make wrappers to libraies written in another language.

	private			- 	Declares only accesssable within this class, and sub classes.
	protected		-   Declares only accessable within this library namespace.
	public			- 	Declare for public and use external to this library or programme after build.
	final			- 	Element cannot be editied or reassigned.
	const 			-   Reserved, unused. Presumably superceeded by final.
	
	static			-	Declare bound to classification, not instance.
	volatile		-	field is volatile; reads will always be taken from main memory and never from CPU cache.
	
	FLOW CONTROL
	continue		- 	Continues to resume a the end of enclosed loop body. If labels are used, resumes at end of current label.
	for				-	used to define a for loop
	if				-	creates an conditional code block
	else			-	optional addition to if, entered if statement was not true.
	do				- 	Creates a do-while. reverse while.
	while			-	Creates a loop which continues whilst a condition is true.

	switch			- 	creates a conditional multiblock, where a block selected based on matching the input.
	case			-	case condition for a switch
	default			-	default case for a switch, entered if no cases matched. Optional.
	
	goto			-	Reserved, not used. Presumably would have been for jumping to labels.
		
	break			-	exits current loop body
	throw			-	throw a runtime exception

	try				- 	Attempt to perform a routine, and catch exceptions to handle locally.
	catch			-	Used to catch and handle uncaught exceptions of matching types.
	finally			- 	Optional try extention, always entered after try routine is complete, regardless of if an exception was thrown. Could be used to display or deal with result, for example.

	return			- 	Return from current method. With void return types, this isn't required - but can be used to return early. With functions, return is required to return the output value.

	GENERAL
	super			-	reference to class this one extends.
	new				- 	Create a new instance of a class
	assert			- 	Marks that a value should be equal a specified value at this point of execution. If not, an assertion failiure is risen, causing halt or invoking debugger.
	package			- 	Declares this file to be a member of this library package. Must be fully qualified package name, not directory or local name.
	this			- 	Reference to the current object instance. Cannot be used statically. Typically can be ommitted.
	import			- 	Imports a package or class for use in the current class.
	
	strictfp		-	Restricts rounding and precision on floating point to ensure portability; ensuring the same result on every platform, since different platforms handle and calculate floating points differently.
	instanceof		-	system function; takes a instance and an interface, evaluating to true if the instance is compatable with the interface, identifying it as an instance of that type.
	
	TYPES
	boolean			-  	Single bit with two states
	byte			-	four bits, can be set as 0x0000 or as ints between 0 and 255. Use this for positive numbers less than 255 to save memory.
	short			-	Shortened int, whole numbers between -32,768 and 32,767. Use for smaller ints to save memory.
	int				- 	Whole number between -2,147,483,648 and of 2,147,483,647
	long			- 	Large int, -9223372036854775808 and 9223372036854775807. (Java does not have an unsigned int, this is best you get.)
	float			- 	Integer with a movable decimal point
	double			-	Double precision float
	
	char			-	Ascii standard character value. String is a class which stores an array of chars, not a data type.
	void			-	Devlared no data type

	class			-	Declares an object classification for properties, methods and functions.
	enum			- 	Enumerated type, essentailly list of selectable items. All enums are an extension of the enum class.
   */

}
