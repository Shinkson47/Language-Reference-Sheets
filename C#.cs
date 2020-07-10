// comment

/* inline comment */

/*
	Comment 
	block
*/

/// C# XML formatted element docstring
/// <summary>	</summary>	Describe a type or a member of a type
/// <c>	</c>				Set text in a code-like font
/// <code>	</code>			Set one or more lines of source code or program output
/// <example>	</example>	Indicate an example
/// <exception>	</exception>Identifies the exceptions a method can throw
/// <include>	</include>	Includes XML from an external file
/// <list>	</list>			Create a list or table
/// <para>	</para>			Permit structure to be added to text
/// <param name="">	</param>Describe a parameter for a method or constructor
/// <paramref>	</paramref>	Identify that a word is a parameter name
/// <permission>	</permission>Document the security accessibility of a member
/// <remarks>	</remarks>	Describe additional information about a type
/// <returns>	</returns>	Describe the return value of a method
/// <see>	</see>			Specify a link
/// <seealso>	</seealso>	Generate a See Also entry
/// <value>	</value>		Describe a property
/// <typeparam>				Describe a generic type parameter
/// <typeparamref>			Identify that a word is a type parameter name

// Class level import; this file is using this package or class.
using System; // import c# system.

// Namespaces = packages.
// Packages are NOT infered from directory like in java, but by namespace decleration.
// Multiple classes and namespaces can be declared within one file.
namespace examplePackage{

	// Namespace level class, with no extention.
	public  class exampleClass {
		#region example Region
			// Organisation feature, similar to Java's //#region.
			// IDE's should be able to fold this region.
		#endregion

		/// <summary>C# class level property</summary>
		/// Variables are defined in the same format as java;
		/// modifyer type camelCaseTokenName (= value);
		int classLevel = 1;

		/// <summary></summary>
		private int privateClassLevel = 1;

		/// <summary></summary>
		protected int privateClassLevel = 1;

		/// <summary></summary>
		public int privateClassLevel = 1;

		/// <summary></summary>
		public static int privateClassLevel = 1;

		/// <summary></summary>
		public static readonly int FINAL_CLASS_LEVEL = 1;
	}

	// Namespace level STATIC class, extending the exception class.
	// Unlike java, in c# you can declare a class to be static.
	//
	// c# has no interface, only extentions, however 'virtual' methods in a class achive the same
	// kind of thing, virtual methods are overridden in the extention class.
	public static class extentionClass : Exception {
		// Example override. Replaces interface.
		public override GetBaseException(){}
	}
}

/*
document attributes.

Class
Variables, types, Access modifyers
Scripting / functions / method / return types
Flow control - if, else, elif, for, foreach, while
Error handling - try, throw, catch, unhandled, etc
Wild cards, uniqitues. 
annotations c# # annotations 

#region

#if DEBUG
    Console.WriteLine("Debug version");
#endif
Keywords 
*/