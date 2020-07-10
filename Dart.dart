// Dart introductory code lab: https://codelabs.developers.google.com/codelabs/from-java-to-dart/#0
// Objects in this class are taken from the Oracle Java introduction, modified for Dart.

// Dart does not support regions (like #region [token] or //#region [token]).
// comment

/* inline comment */

// Dart packages are at minimum a directory containing a pubspec.yaml file (this file declares dependencies and namespace)
// Packages contain libraies, which are inherited from directory and file declerations.
// IDE's handle this.
//
// Imports are formatted as:
// import "package:library/file.dart" (as token);
//
// (as token) allows a class, package, or library to be imported and accessable under a custom token.
import "dart:math";


/// C# style Docstring
///
/// Preffered by documentation, since java style adds two extra lines with no useful content.
/// Dart docs do not have stylisation attributes, such as:
///  Java:
///    @author
///    @example
///
///   C#:
///     <summary></summary>
///     <c></c>
///
/// Types and elements can be placed in square brackets, such as;
///   Throws [IOException] if...
///
/// It also supports markdown-esque code snippets:
///   ```dart
///   min(3,5) = 3
///   ```
///
/// Dart documents say to always include a snippet example; humans are great at
/// making assumptions and generalising from a quick example. It makes your code
/// easier to learn.
///

/**
 * Java style docstring is supported, but depricated.
 *
 * I believe this style supports the exact same usage ettiquette as above, just
 * written in this kind of block.
 */


// Dart takes leaves from many languages books;
//  Scripting nature as seen in python,
//  Commenting and documentation systems from java and C#,
//  Object oriented standards from various HLL's,
//  Syntax from large laanguages, namely java, to make it easier to get into for
//    users of other languages.

// In short, it's usage is akin to python; scripting language with OOP capabilities,
// and the syntax of java. Google tried to take the best of all worlds to make a super language.
// I like it.

// IntelliJ handles dart significantly better than VS Code.
// Linting actually works too.


/// Same effect as Java's main.
/// Since this is a scripted language, it can be namespace level, not class level.
/// This also means that it does not need to be made static.
/// 
/// Unlike java, command line arguments are optional.
/// They can be accessed with a List of type string, as opposed to an array.
void main(List<String> args){
  // Similarly to java, dart statements are REQUIRED to end in ';'.

  /// Create a new instance of the bicycle class,
  /// with no stored reference.
  ///
  /// Note that since Dart 2, the 'new' keyword is optional.
  /// Invoking a constructor infers a new instance, without needing to use 'new'.
  ///
  /// this is the same as:
  /// ```dart
  /// print(new Bicycle(0,0,0));
  /// ```
  /// Both are valid.
  print(Bicycle(0,0));

  /// Invokables with optional arguments replace overloads.
  /// Rectangle has a constructor with three optional tokens.
  /// Any combination or order of these tokens may be assigned when invoking the constructor.
  /// Tokens are assigned by name, such as 'width: 5'
  print(Rectangle(origin: Point(10,10), width: 5, height: 5));


  /// from codelab. Just different instances for view.
  print(Rectangle(origin: Point(10, 20), width: 100, height: 200));
  print(Rectangle(origin: Point(10, 10)));
  print(Rectangle(width: 200));
  print(Rectangle());
}
/// Simple bicycle class.
///
/// from the Google Codelab for learning dart. Class is intended to direcltly copy the functionality
/// found in the java example class.
///
/// Although a scripted language, entire files are parsed for definitions before
/// execution begins. This allows for functions and classes to be defined in any order,
/// and entirely unlike python where they must be defined above where they're used.
class Bicycle {

  /// Default constructor with no body.
  /// Dart removes the requirement to take parsed values, and set them in a body.
  /// Bodied constructors are possible, but not required.
  ///
  /// This constructor is functionally the same as this.
  /// ```dart
  /// Bicycle(int cadence, int speed, int gear) {
  ///   this.cadence = cadence;
  ///   this.speed = speed;
  ///   this.gear = gear;
  ///  }
  /// ```
  Bicycle(this.cadence, this.gear);

  /// private, class level integer variable with no default.
  /// Variables are private by default.
  /// access modifiers such as 'private', 'public', 'package', etc don't exsist in dart.
  /// Rather, access in infered by scope, or privatised with a leading underscore (_), just like in python.
  ///
  ///
  /// class level variable getters and setters are implicit for public tokens.
  int cadence;

  /// speed of the bicycle
  /// example of a private variable. Only accessible within library (this class and subclasses).
  /// compiler enforces library privacy on tokens prefaced with an underscore.
  /// implicit getters and setters do not exsist for this token.
  /// 
  /// ##################################
  /// VITAL NOTE: uninitialized tokens ALWAYS evaluate to NULL; even numbers, booleans and such. There are no infered
  /// default values.
  ///
  /// This benefits finals. final values cannot change once assigned. Not assigning tokens defaults allows for
  /// tokens to be dynamically constructed, but after which not be changed.
  /// ##################################
  /// Since this token is not set in the constructor, it SHOULD be initialized to a default.
  int _speed = 0;

  /// Declared getter.
  ///
  /// Not a typical method. Getter for privatized _speed token.
  int get speed => _speed;

  /// current gear of the bicycle
  int gear;

  /// Classes all have a 'to string' function. This can be overriden to prodive
  /// a different return when toString is invoked on this class.
  ///
  /// return type is infered, just like python and scala.
  // Annotations are just like in java, with '@[token]'.
  @override
  // single statement functions (and methods) can be more simply mapped with the '=>' (Fat arrow)
  // operator, just like in c#. values can be evaluated into a string using '$', just like bash.
  // This removes the need to use '+' to concatenate different strings into one.
  toString() => "Bicycle[cadence: $cadence, gear: $gear, speed: $_speed]";

  /// Slows bike by 1 unit.
  ///
  /// Simple method applied to bicycle.
  void slow() => slowBy(1);

  /// Slows bike by specified quantity of units.
  ///
  /// In other languages you could have two methods with the same token
  /// and different parameters. This is not possible in dart, it does NOT
  /// support method parameter overloading.
  /// it does, however, support optional arguments instead. See below.
  void slowBy(int quantity) => _speed -= quantity;
}

/// Example of optional parameters.
class Rectangle{

  /// Constructor with OPTIONAL parameters.
  /// Tokens surrounded by '{}' inside the constructor are not required, but may0000
  /// be assigned using the token's name on constructions,
  /// ```dart
  /// new Rectangle(height: 10) = Rectangle[origin: Point[X: 0, Y: 0], width: 0, height: 10]
  /// ```
  ///
  /// These tokens may be set on construction, but it's not enforced. It's entirely optional.
  /// Thus, these values should have defaults - else they' be null.
  /// Defaults may be done in the constructor or at the class level token decleration.
  /// Either way, default values will be overiden by constructor token assignments.
  Rectangle({this.origin = const Point(0,0), this.width = 0, this.height = 0});

  Point origin;
  int width;
  int height;

  /// Provide a printable format of this object's data.
  @override
  toString() => "Rectangle[origin: $origin, width: $width, height: $height]";
}










/// Example of an object factory, abstraction, extention.



/// Interface class.
///
/// Adds a 'getArea' getter..
///
/// Interfaces do exist but unlike java they're inherited from classes. interface decelerations do not exist.
class Area{
  /// Any method can be used as an implementation.
  /// It must be implemented in the default class, but it's body may be empty.
  num get getArea => 0;
}

/// Shape abstract.
/// Abstract classes are used just like c#.
///
/// Just like c# and java, members from inherited classes must implemented.
/// Any class implementing another inherit's its interface (Methods, ways of interacting with the class), but not the functionality
/// of the class. The class must implement new bodies with it's own functionality.
abstract class Shape implements Area {
  /// This looks like an inherited method from the implemented 'Area' class,
  /// but is actually an override. It perfectly matches and replaces the inherited method, re-implementing it.
  num get getArea {}
}

/// Implementing abstraction is just like java and c#.
/// In c# or java, this would be a 'final class' to prevent further extention, but in dart this isn't directly possible.
class Circle implements Shape{
  /// This is an implemented token inherited from Area, via Shape.
  /// Implemented is the same as the inherited token, with a custom body.
  num get getArea => pi * pow(radius, 2);

  /// Radius of this circle.
  ///
  /// Not set by default, set by constructor.
  /// final, once set this token will not change.
  final num radius;

  /// Create a new circle instance, with a required radius.
  Circle(this.radius);
}

/// Classification of a square object.
/// A shape with four side of equal length.
class Square implements Shape {
  /// A different implementation of getArea, as inherited from Area via Shape.
  num get getArea => pow(side, 2);

  /// Create a new square, with required length for it's sides.
  Square(side);
  int side;
}