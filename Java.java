// comment

/* inline */

/*
	comment
	block
*/

/* 
	Java does not have have standardised regions such as to c#'s '#region',
    However, some IDE's have thier own standard for folding regions using comments.
*/

//#region example
/* 
	IntelliJ and VS Code can fold (collapse) these regions with an arrow to the left of
	line numbers. 
	
	Eclipse does not seem to support these regions, but eclipse is an aging platform in general, and i try to avoid it. At all costs.
*/
//#endregion

// TODO This thing needs to be added here. 
// IDE's usually collect todo comments into some kind of to-do checklist, and highlight them in code views. 
// Intellij warns of remaining to-do comments upon export and git commits to remind you that you may need to complete your todo's before handing your code to others.
// Unless your api is open source, these comments will not be recieved by an api user. See the javadocs '@todo' below.

// Java documentation
/**
 * JavaDocs title
 * 
 * Javadocs element description. Javadocs is the documentation standard for all java elements.
 * It is not included in compiled bytecode, but it is published in released library JAR's.
 * it is intended to help humans that're using your API, even if they cannot view your source,
 * serving as a summary and guide for your symbols.
 * 
 * Including yourself when you forget how your own code works 2 weeks from now.
 * 
 * Javadocs are writting in HTML, meaning HTML tags are supported such as <p></p>, <a href="#{@link}">{@link URL}</a>, <i>italic</i>, <em>emphasized</em> etc.
 * 
 * Tag notes to API users. These are rendered differently in IDE's, 
 * they isolate the most important information about a symbol from the general description
 * 
 * @apiNote		Note to a user of your API. 	(You should initialise this thing before using this method!)
 * @implNote	Implementation note				(When you implement, remember that you need to do this to your parameters else you may enounter maloperation)
 * @implSpec	Implementation specification 	(custom requirements / rules for a user to correctly implement your api call.)
 * 
 * @deprecated	Indicates that this should no longer be used. May provide alternative, and version in which this symbo will be removed.
 * @see			Look at this (Reference page, documentation, another symbol etc)
 * 
 * 
 * @serial		This symbol is serializable (see Java's Serializable documentation)
 * @serialField "" field
 * @serialData	"" data
 * 
 * @since		The project / library version this symbol was added
 * @version		Version of this symbol. Change when a symbol is modified.
 * @author		Creator of symbol, typically a class.
 * 
 * @throws		ExceptionName is thrown in this condition.
 * @exception	ExceptionName. Exists for backwards compatability, same as @throws, but doesn't read as smoothly.
 * 
 * @hidden		Not sure, not well documented, but it's mentioned in the standard. Perhaps for symbols hidden from the outside world, like protected and private.
 * 
 * @CustomTag   You can use any tag you like, Create your own standards - but don't expect them to be rendered with special treatment on api user's IDE's.
 * 
 * Tags proposed by Oracle but not (yet) implemented :
 * @category	For logically grouping classes, methods, fields. May get shortened to @cat.
 * @example  	Example usage of element
 * @tutorial	link to a tutorial. Essentially equal to @see.
 * @todo		For marking released material incomplete, or requiring work, with a description of work. Same as //TODO, but notifies API users.
 * @internal	Holds note that's internal to the production company only.
 */

// Package level elements. (Directly in the file, not inside a class.)
// Few things can be at package level in a java file.
// 1) Meta (package decleration, imports, Annotation)
// 2) object (Class, enum, interface, annotation)

// package
// Packages are intelligently infered from directory, but classes MUST declare themselves
// to be in the package with the first line in the FILE, NOT CLASS.
// i.e package com.shinkson47.playground.tools;
// package names should NOT contain ANY capitalized or special characters.

// imports
// To access other packages, they must be imported.
// IntelliJ and eclipse automatically handle and organise imports.

// Force organise (IntelliJ, Eclipse)
// Mac - Cmd ⌘ + Shift ⇧ + o
// PC  - Ctrl  + Shift ⇧ + o

// Force organise (VS Code)
// Mac - Option ⌥ + Shift ⇧ + o
// PC  - Alt      + Shift ⇧ + o

// Import all in package with
// import library.package.*;
// Symbols in the same package level do not require importing.

import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/*
	Basic anatomy of a Java Symbol Definition.

	1) access modifyer (Determines what objects may access this symbol).
	2) static and/or final decleration ()
	3) Type Parameter (For methods, optional, advanced feature. Used for abstraction.)
	4) Type (Return / Value.)
	5) Symbol Name (Method convention is verbAdjective)
	6) Braces (Indicates invokability - there's an invokable body of code. contains parameters.)
	7) Throws (Declares that this method may throw a throwable notification when called. 
				This may be an Exception, indicating an error, or some other kind of progromatic notification. 
				These declerations must be handled by the code that calls the function.)
	8) Body (Invokable code content)
	9) return <ReturnType>value - (Sets the value that the call to this method will evaluate to, and returns to the method call.)

	Symbol Definition:

	public static final int calculateNumber(int param1, int param2) throws NumberException {
		// body content
		return result;
	}

	Signature of above symbol definition:

	public int calculateNumber(int, int)
*/

// Convention for reffering to a member of a symbol (I.e a method in a class)
// progromatically, a period is used, i.e :
// class.Method();
// However, in writing such as documentation, '#' is used instead. Progromatic syntax is also omited :
// class#method

// Symbols: 

// {} indicates a collection of executable statements.
// <> indicates a type parameter
// \  escape character (Reverse solidus)
// () Mathmatical / Logical grouping. Executed first in calculation.
//    Also indicates invokability, and contains
// &  Bitwise AND : 
//    When comparing, directly validates the bits of BOTH operands at a bit level.
//    Both operands WILL be evaluated. for example;
//    j & (y != 0)
//    Essentailly, both 'j' and (y != 0) will be evaluated THEN & will be performed on the bit 
//    result of both operands.

// && Locical AND :
//    Compares the evaluation value of both operands, itself evaluating to true of both results are true.
//    Because a true value from this expression REQUIRES BOTH operands to evaluate as true, this
//    has a behaviour whereby it will stop evaluating if any operand is not true.
//    This behaviour can be used to evaluate an expression only if a condition is met;
//    i.e : bool x = j && (y != 0)
//    This example would only exaluate the result of (y != 0) if j is true.

// Similarly, Bitwise and logical OR
// exprA | exprB <-- this means evaluate exprA then evaluate exprB then perform | on the results.
// exprA || exprB <-- this means evaluate exprA, if false evaluate exprB and do the ||.

/**
 * Java is OOP only, however it can behave as a scripting language by with the
 * use of static methods (Methods that do not belong to or act on an instance of
 * an object)
 *
 * Java files must contain a class. Every symbol must belong to a class. Classes
 * can be used to define an object, abstract, interface,
 * 
 * They can extend upon another class with 'extends'.
 * 
 * public class a extends b {}
 * 
 * Extending almost feels as though you're adding to the end of the class you're
 * extending, building on top of it. The class extending is called the
 * sub-class, and the class you've extended is the super class, and can be
 * referenced using the 'super' keyword, although you can reference the symbols
 * within the super as if they were in the class extending it.
 * 
 * subclasses have all non-private symbols found in the super class and thier
 * class. Super class can be accessed natively as if it were in the extended
 * class, or directly with 'super' keyword.
 * 
 * extentions can also hide / replace inherited elements, thus keeping the same
 * interface but replacing the behaviour. See the @Override annotation.
 * 
 * subclasses can also be extended, but a class can be declare as 'final' to
 * indicate it's the final element on this branch of class extentions,
 * preventing it from being extended any further.
 * 
 * 
 * 
 * 
 * Interfaces declare the methods of interaction that must exsist within a group
 * of classes, but do not implement any logic that these methods perform.
 * 
 * As well as extending ONE other class, a class may also implement multiple
 * interfaces. Interfaces are a decleration that this class will implement all
 * methods defined in the interface.
 * 
 * For example, any type of music player class (i.e CD player, Online Stream)
 * that implements 'Playable' must implement a pause(), next() and previous()
 * method. How these classes handle the logic to perform those functions is
 * entirely up to the implementing class.
 * 
 * This way it's possible to create a music control system or user interface
 * that could control any of these types of music players, even though they have
 * entirely different logic under the hood to perform those same actions.
 *
 * 
 * 
 * 
 * 
 * The entirety of a class is parsed and stored inside an object on the Java
 * Virtual Machine before it can be accessed.
 * 
 * Since the entire class is parsed before you access it, it means that class
 * level content can be typed and accessed in any order. Methods at the top of
 * the class use methods below it; unlike python which parses files from top to
 * bottom, executing class level script as it goes. If a script calls a function
 * that has not yet been parsed, because it is further down in the file, python
 * halts.
 * 
 * Entire classes are parsed into Java Bytecode before they may be executed on a
 * Java Virtual Machine, which strips all human friendly aspects from it.
 * Exported code is not end user friendly. When releasing code for other people
 * to use, Open source libraries contain sources, ideally with comments (and
 * javadocs!), closed source libraries are only documented with javaDocs to
 * guide the users.
 */
public final class Java implements Serializable {
	// A blocks of multiple statements is defined by wrapping the statements in {}.
	//
	// In flow controlled bodies, single statements can be infered without the need
	// to declare a block of
	// statements - for example
	//
	// if(true) doThis();
	// instead of
	// if(true) { doThis(); }
	//
	// This is true for flow control bodies (while, for, switch, if, try, etc),
	// but NOT the declaration of a symbol.
	// Method and class bodies must be declared with {}.

	// Executable statements MUST end with a semicolon (;), even if there is only
	// statement per line. Java cares for statements, not lines.
	// lines =/= statements =/= an instruction.

	/*
	 * Simplified access modifier table
	 * 
	 * Modifier Class Package Subclass World
	 * 
	 * public Y Y Y Y
	 * 
	 * protected Y Y Y N
	 * 
	 * no modifier Y Y N N
	 * 
	 * private Y N N N
	 */

	/**
	 * Java class level property symbol.
	 * 
	 * variables are defined in the format:
	 * 
	 * type camelCaseSymbolName (= value);
	 * 
	 * Note that in Java types are never infered - types MUST be declared. Types are
	 * either objects (enum, class instance) or a raw data type (byte, float, short,
	 * int, etc)
	 * 
	 * Linting and building will fail assignments incompatable by type, or symbols
	 * missing a type.
	 * 
	 * Try to always declare with an appropriate access modifier, not like this.
	 * Since this has no access modifier, it's class level - meaning it can only be
	 * accessed by classes in the same package as this one.
	 */
	int classLevel = 1;

	/**
	 * private property. Only accessable in this class. Use for symbols that users
	 * should not be able to directly access, for example a variable who's value
	 * this class relies on. Privatise it to prevent external modification.
	 * 
	 * Even extention subclasses cannot access private symbols.
	 * 
	 * Remembering that public getters and setters can be used to allow, but
	 * customly control, access.
	 * 
	 * Linter will warn of private elements that are not used locally, since they
	 * can only be used here.
	 */
	private int privateClassLevel = 1;

	/**
	 * Protected. A Value for the internal workings of a library, accessable within
	 * this class, package, and classes that extend this.
	 * 
	 * It will not be accessable by users of the library.
	 */
	protected int protectedClassLevel = 1;

	/**
	 * publicly read and writable property.
	 * 
	 * Public variables should be avoided, unless they're INTENDED to be visable and
	 * changed outside of this class. Otherwise concider other modifiers with
	 * getters and setters to controll read and write access as appropriate.
	 * 
	 * IntelliJ, VS Code and scummy Eclipse can all generate getters and setters
	 * automatically from context menu (right click) on a symbol.
	 */
	public int publicClassLevel = 1;

	/**
	 * static property Always only one instance, free of any instances of this
	 * class. Static should be PascalCasing not camelCasing
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
	 * Actively generated constant.
	 * 
	 * Constants cannot be changed once set, but they must be set upon creation.
	 * Functions can be used to actively set the content of a constant value.
	 * 
	 * Quick Tip: IDE's commonly allow you to focus on a symbol's definition by ⌘ or
	 * Control Click on a usage of it. cmd click getTime(), and your ide should
	 * scroll to it.
	 */
	public static final long TIME_OF_BOOT = getTime();

	/**
	 * Default constructor Will be invoked upon a new instance of this class. Used
	 * to dynamically prepare and configure a new instance.
	 * 
	 * Can be class, public, protected but never static; it's unique to each
	 * instance of this class. To perform initialisation scripts on a static symbol,
	 * a class level block preceded by 'static' will be executed when the class is
	 * first parsed; i.e:
	 * 
	 * class i {
	 * 
	 * static { log("class i has been initalised"); }
	 * 
	 * }
	 * 
	 * Can also be used to prevent creating instances of this class by defining it
	 * as private.
	 * 
	 * Ommiting the default constructor, but implementing one with a different
	 * signature (i.e with parameters) hides the default constructor, enforcing
	 * parameters upon creation.
	 * 
	 * Has no return type, and a name which matches the class name. Automatically
	 * invoked upon "new Class()"; i.e Java myJava = new Java();
	 * 
	 * Can have parameters. Multiple constructors should call each other in a chain
	 * with default vaules to replace those not specified (Method Overloading). This
	 * is a level 2 overload.
	 * 
	 * Optional, ommmit if no initalisation logic is required, hide if class is not
	 * instantiable (static).
	 */
	public Java() {
		this(1);
	}

	/**
	 * Level 1 overload.
	 * 
	 * unlike the default constructor, those with parameters are never inheritly
	 * called, they must be called deliberately with specified parameters.
	 * 
	 * @param i
	 */
	public Java(int i) {
		this(1, 2);
	}

	/**
	 * Main constructor.
	 * 
	 * @param i
	 * @param j
	 */
	public Java(int i, int j) {
		// super(i); On a subclass, any constructors for the superclass must be called
		// before the extention.
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
	 * of this type, not an instance. Use non-static methods for operations that
	 * effect an instance of an individual instance.
	 * 
	 * Methods MUST declare a return type, even if it does not return anything. The
	 * keyword 'void' can be used in place to declare that a method that does not
	 * return a value.
	 * 
	 * linter will warn of private symbols that are not used locally, since they
	 * cannot be used anywhere else.
	 */
	private static void StaticMethod() {
		return; // Return to the caller. Don't continue any further.
				// Methods with no return type do not require this, but it can be used to exit
				// prematurely.
	}

	/**
	 * Functions map an input to an output. Method with return types may be
	 * concidered a function if they predictably return a output that is
	 * mathematically correlated to the input.
	 * 
	 * A functions return type must not be void.
	 * 
	 * In a function, a return statement is required to be reached on all possible
	 * paths the code may take (see flow control below), and it must return a value
	 * of the same type declared i.e:
	 * 
	 * if(true){ return this; } else { return this; }
	 * 
	 * OR
	 * 
	 * result = (true)? a : b;
	 * 
	 * return result;
	 * 
	 * @param input
	 *                  number to add one to.
	 * @return <c>input</c> + 1
	 */
	public static int StaticPlusOne(int input) {
		return input + 1;
	}

	/**
	 * Gets current system time, in milliseconds
	 * 
	 * Oracle's suggested naming convention for methods is: verbAdjective.
	 * 
	 * @return System.currentTimeMillis.
	 */
	public static long getTime() {
		return System.currentTimeMillis();
	}

	/**
	 * Ternary operator (short 'if'). Chooses a value based on a condition.
	 * 
	 * Extremely useful, use where you can. return a value based on a condition.
	 * output = condition ? valueIfTrue : valueIfNotTrue;
	 * 
	 * i.e getPrefferedInput(){ return preferKeyboard ? keyboard : controller; }
	 */
	public static int TernaryFunction(int i) {
		return (i > 100) ? 0 : 1;
	}

	/**
	 * General flow control options;
	 * 
	 * Controlling the flow of your code by creating paths which are transversed
	 * based on conditions.
	 */
	public static void FlowControl(boolean flow) {
		if (flow) { // IF this
		} else if (flow) { // ELSE if this
		} else { // ELSE
		}

		if (flow)
			return; // Remember, single statements can be inherited without {}

		while (flow) { // Whilst condition, repeat block.
			flow = false; // Condition must be changed to stop loop.
			continue; // Skip rest of this loop and start next one.
			break; // Completely break free of while loop, and skip to code below it's body. Linter
					// should indicate this cannot be reached, because of the continue above it.
		}


		// A while loop, but the body is defined before the condition.
		// The only differece being the body of a do while will ALWAYS be executed at least once, before the condition is
		// evaluated.
		do {
		} while (flow);

		// Itterates over an itterateable object instance, such as a list or array of
		// items.
		// The current item is stored in i.
		// Used for completing a task to every item in a list, or performing a linear
		// searching for an item.
		for (Object i : new ArrayList()) {
			continue; // Skip the rest of this block
			break; // break out of for loop entirely. Wont be reached, because of the continue
					// above it.
		}

		// Error handling
		try {
			throw new CustomException("yeet");
		} // Try to complete a routine which can throw exceptions. Use to handle continued
			// operation when things don't go as expected.
		catch (OutOfMemoryError e) { // Catch and handle specific exceptions
		} catch (CustomException e) { // Catch can only catch elements in the extention branch of Throwable from the
										// type provided onwards. This one could catch and handle CustomException or
										// anything extending it, but not elements higher in the branch (Like an
										// instance of java.lang.Exception), or on a different
										// branch (such as an IOException)

		} catch (Exception e) { // Handle any generic unknown exception
		} catch (Throwable e) { // Handle absolutely anything that may be thrown. Throwables do not have to be
								// errors, in some flow control scenarios, a throwable could be used to indicate
								// different kinds of runtime notification.
		} finally { // Always executed after a tried routine, unconditionally, even if it fails.
		}

		/*
		 * post space
		 * 
		 * Concider the space at the end of your flow similar to the 'finally' block on
		 * a try. Assuming there's no 'return' above here, this code will always be
		 * executed, regardless of the result of the operations above, perhaps operating
		 * or modifying a result from above.
		 */
		return; // Automatically infered on methods with no return type.
	}

	/**
	 * Classified object within a class.
	 * 
	 * Also known as subclasses (can be confused with extention subclasses) or
	 * better known as non-top level classes.
	 * 
	 * 
	 * These can be useful to define small classes, such as exceptions or custom
	 * data containers, that're only used locally or in relation to the parenting
	 * class. If this could be re-used in relation to another class, define it in
	 * it's own class.
	 * 
	 * Example of extention, and a custom exception.
	 * 
	 * 
	 * Exceptions are a class with error information. All exceptions extend
	 * java.lang.exception, which extends java.lang.throwable (which can be used in
	 * unique flow control scenarios to throw and catch other kinds of
	 * notifications.) and custom ones can be built for custom errors in custom
	 * routines. Remembering that catch statements can catch a type, and sny
	 * subclasses of that type.
	 */
	class CustomException extends Exception {
		// Exceptions are serializable, this declares compatability with serialized
		// versions of this class. As the signature of this class changes, this version
		// should change to indicate that older serialised versions of this class are no
		// longer compatable. See Java's Serialization.
		private static final long serialVersionUID = 1L;

		/**
		 * Constructor
		 * 
		 * Custom exception stores a message just like a normal exception, but will also
		 * display it in a message box to the user automatically when the error occours.
		 * 
		 * @param customExceptionMessage
		 *                                   message to store and display
		 */
		public CustomException(String customExceptionMessage) {
			super("Custom Exception:" + customExceptionMessage); // Parse message to constructor of super (extended
																	// exception class)

			// This message box will be shown as the error is constructed.
			// It may still be handled, there's no way to know here.
			JOptionPane.showMessageDialog(null, customExceptionMessage); // Display message in message dialog, with null
																			// parent.
		}
	}

	/**
	 * Furthermore, this class shows how understanding trees of object inheritance
	 * are important for extentions.
	 * 
	 * This is what our linear type extention tree looks like, there is only one
	 * branch. Note that all classes are inherently extentions of 'java.lang.Class',
	 * which extends 'java.lang.Object'.
	 *
	 * Object => Class => a => b
	 */
	@SuppressWarnings({ "unused", "static-access" })
	public static class inheritance {

		/**
		 * Class 'a' will serve as the top level of our branch.
		 */
		private static class a {
			public static final int MEMBER_OF_A = 1;
		}

		/**
		 * Class 'b' is only second level in the branch.
		 */
		private class b extends a {
			public static final int MEMBER_OF_B = 1;
		}

		/**
		 * As a type of 'a', this variable can store any instance of 'a', or classes
		 * that extend it - however anything added in an extention will not be
		 * accessable.
		 * 
		 * Refferences to this variable will only see the type 'a', and thus only be
		 * able to access the members of 'a'.
		 */
		private a _instance = new b();

		private void accessTree() {
			int i = _instance.MEMBER_OF_A; // Possible
			i = _instance.MEMBER_OF_B; // Not Possible
		}
	}

	/**
	 * Enumerator's are list of options which are selectable and comparable. enums
	 * replace the need to use final variables to declare options using ID's, id no
	 * id is needed (like KeyEvent.VK_..., see above.)
	 * 
	 * They also replace the need to use an object instance populated with the same
	 * data, but only if the possible options do not need to be changed at runtime.
	 */
	enum customModes {
		Mode1, Mode2, Mode3, Mode4, NoMode
	}

	/**
	 * Current mode defaults to noMode
	 */
	public static customModes mode = customModes.NoMode;

	/*
	 * =============== IMPORTANT FOP ANNOTATIONS SECTION BELOW =================
	 * 
	 * IN RETROSPECT, I REALISE THAT ANNOTATIONS ARE, IN FACT, STATIC. THIS EXAMPLE
	 * REQUIRES NON-STATIC USE SUCH THAT EACH IMPLEMENTING METHOD HAS THIER OWN
	 * INSTANCE OF 'ENABLE', HOWEVER THEY WOULD ALL HAVE THE SAME VALUE. AND IT'S
	 * ALWAYS DISABLED.
	 */

	/**
	 * Annotations are meta data on symbols for either runtime, build time or for
	 * the editor only.
	 * 
	 * Such as the inbuilt annotations;
	 * 
	 * @SuppressWarnings("warningName"), - Prevents warnings from this element.
	 * 
	 * @Override, - This symbol overrides one of the same name in an subclass
	 * 
	 * @Depricated - This element is marked to not be used.
	 * 
	 *             This class shows how they are defined. Like an interface, 'class'
	 *             is replaced with 'interface' but to delcare as an interface for
	 *             an annotation, it's preceded with '@'
	 * 
	 *             Annotation definitions are also annotated with meta on how
	 *             they're intended to be used.
	 */
	@Retention(RetentionPolicy.RUNTIME) // Intended for runtime (This is an annotation with an Enumeration parameter!)
	@Target(ElementType.METHOD) // and use on a method. (Another annotation and Enum!)
	public @interface customAnnotation {
		// Can have a constructor to take values, like the annotations above.

		public boolean enabled = false; // Methods with this annotation will have an 'enable' boolean, which is false by
										// default
	} // Custom annotation code could check this to see if the method is enabled
		// or the method could use it to reject being called.
		// i.e:

	@customAnnotation()
	public void annotationExample() {
		try {
			Method m = getClass().getMethod("annotationExample"); // Get this method
			customAnnotation a = m.getAnnotation(customAnnotation.class); // Get annotation matching my type from method
			if (!a.enabled)
				return; // If annotation not enabled, return.
		} catch (NoSuchMethodException | SecurityException e) {
		}
	}

	/**
	 * All Java Keywords, categorised and described.
	 * 
	 * MODIFYERS
	 * 
	 * abstract - Method with no definition. Must be contained within an abstract
	 * class. Cannot be used on vars. Sub classes must inherit.
	 * 
	 * 
	 * synchronized - Method or block aqquires mutex lock. Ensures that only one
	 * thread at a time can operate on an object. Lock is released when sync code
	 * block is exited.
	 * 
	 * implements - Specifies one or more interfaces used by a class.
	 * 
	 * interface - Declares class to be an interface.
	 * 
	 * extends - Class is an extention of another. Can only extend a single class,
	 * but extended classes can be chained.
	 * 
	 * throws - This method can throw a runtime exception. Required where throws are
	 * not caught.
	 * 
	 * transient - Declares element to not be a part of a serialized object.
	 * 
	 * native - Method functionality is written in a different language, not this
	 * class. Can be used to interface system calls, or make wrappers to libraies
	 * written in another language.
	 * 
	 * 
	 * 
	 * private - Declares only accesssable within this class, and sub classes.
	 * 
	 * protected - Declares only accessable within this library namespace.
	 * 
	 * public - Declare for public and use external to this library or programme
	 * after build.
	 * 
	 * final - Element cannot be editied or reassigned.
	 * 
	 * const - Reserved, unused. Presumably superceeded by final.
	 * 
	 * static - Declare bound to classification, not instance.
	 * 
	 * volatile - field is volatile (Changes extremely frequently) reads will always
	 * be taken from main memory and never from CPU cache. Reads will be slower.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * FLOW CONTROL
	 * 
	 * continue - Continues to resume a the end of enclosed loop body. If labels are
	 * used, resumes at end of current label.
	 * 
	 * for - used to define a for loop
	 * 
	 * if - creates an conditional code block
	 * 
	 * else - optional addition to if, entered if statement was not true.
	 * 
	 * do - Creates a do-while. reverse while.
	 * 
	 * while - Creates a loop which continues whilst a condition is true.
	 * 
	 * switch - creates a conditional multiblock, where a block selected based on
	 * matching the input. case - case condition for a switch
	 * 
	 * default - default case for a switch, entered if no cases matched. Optional.
	 * 
	 * goto - Reserved, not used. Presumably would have been for jumping to labels.
	 * 
	 * break - exits current loop body throw - throw a runtime exception
	 * 
	 * try - Attempt to perform a routine, and catch exceptions to handle locally.
	 * 
	 * catch - Used to catch and handle uncaught exceptions of matching types.
	 * 
	 * finally - Optional try extention, always entered after try routine is
	 * complete, regardless of if an exception was thrown. Could be used to display
	 * or deal with result, for example.
	 * 
	 * return - Return from current method. With void return types, this isn't
	 * required - but can be used to return early. With functions, return is
	 * required to return the output value.
	 * 
	 * GENERAL
	 * 
	 * super - reference to class this one extends.
	 * 
	 * new - Create a new instance of a class
	 * 
	 * assert - Marks that a value should be equal a specified value at this point
	 * of execution. If not, an assertion failiure is risen, causing halt or
	 * invoking debugger (if flag is enabled)
	 * 
	 * package - Declares this file to be a member of this library package. Must be
	 * fully qualified package name, not directory or local name.
	 * 
	 * this - Reference to the current object instance. Cannot be used statically.
	 * Typically can be ommitted.
	 * 
	 * import - Imports a package or class for use in the current class.
	 * 
	 * strictfp - Restricts rounding and precision on floating point to ensure
	 * portability; ensuring the same result on every platform, since different
	 * platforms handle and calculate floating points differently.
	 * 
	 * instanceof - system function; takes a instance and an interface, evaluating
	 * to true if the instance is compatable with the interface, identifying it as
	 * an instance of that type.
	 * 
	 * TYPES
	 * 
	 * boolean - Single bit with two states
	 * 
	 * byte - four bits, can be set as 0x0000 or as ints between 0 and 255. Use this
	 * for positive numbers less than 255 to save memory.
	 * 
	 * short - Shortened int, whole numbers between -32,768 and 32,767. Use for
	 * smaller ints to save memory.
	 * 
	 * int - Whole number between -2,147,483,648 and of 2,147,483,647
	 * 
	 * long - Longer integer, -9223372036854775808 and 9223372036854775807. (Java
	 * does not have an unsigned int, this is best you get.)
	 * 
	 * float - Integer with a movable decimal point
	 * 
	 * double - A float with double precision (Supports more decimal places)
	 * 
	 * char - Ascii standard character value. String is a class which stores an
	 * array of chars, not a data type.
	 * 
	 * void - Declared no data type
	 * 
	 * class - Declares an object classification for properties, methods and
	 * functions.
	 * 
	 * enum - Enumerated type, essentailly list of selectable items. All enums are
	 * an extension of the enum class.
	 */
}
