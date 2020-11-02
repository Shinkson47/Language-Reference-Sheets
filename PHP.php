<?php

// STOPSHIP: 12/10/2020

// Comment
/* Block Comment */

// PHP seems to be some strange mash between bash/shell and java(script).
// It's a HTML Pre-processing script, that is to say
// a scripting language that generates / processes data for hypertext pages prior to serving them.
// A simple PHP script could simply echo a HTML literal to the browser:
echo "<a href=\"https://www.shinkson47.in\">This isn't a beach, this is a bathtub!</a>";

/**
 * Loosly typed, types are inherited.
 */
$varName = "literal";

/**
 * Object refference.
 *
 * Purely a pointer to another symbol.
 */
$referenceName = $varName;

/**
 * Referencing zvals within a string is essentially the same as bash.
 */
$interpolation = "name is $varName";
var_dump($interpolation);

/**
 * SINGLE QUOTE VS DOUBLE QUOTE STRINGS
 * Simply, single quote strings prevent any evaluation being completed within the string.
 * You'll see within PHPStorm that the $varname in the string above is purple, but the one below is not.
 *
 * These will evaluate as such
 * ABOVE : name is literal
 * BELOW : name is $varName
 *
 * The purpose of this is to allow the use of symbols in text that would otherwise be treated as code.
 */
$interpolation = 'name is $varName';


var_dump($interpolation);

/**
 * It's suggested good practice to encase interpolation references in braces.
 * I'm not sure why; for clarity? Does it create an anonymous array?
 */
$interpolationBraces = "{$interpolation}";

/**
 * Concatenation is performed with a period.
 * In PHP, the addition operator is purely mathematical.
 * This operator will attempt to parse strings as numerics, however
 * strings that can't be parsed as a number evaluate to 0.
 *
 * Seems as though it's standard practice to have whitespace before and after,
 * presumably as clarification between 'append' and 'member of'
 */
$concatenation = $varName . $varName;

// HEREDOC
/**
 * For defining larger strings, it's can make more sense to use a HEREDOC.
 *
 * With a Heredoc, you indicate the start and endpoints of text within the file, and the evaluator
 * does the rest.
 *
 * Just like any other TODO
 *
 * START
 * Heredoc begins with '<<<' followed by an identifier token.
 *
 * END
 * Closing a heredoc is a bit more picky.
 * To close a heredoc, you just type the identifier again, however;
 *  - It must be preceeded by a newline character        (It must be on a new line)
 *  - It must begin on the first column of a new line    (Directly after the newline character. It cannot be indented.)
 *  - It must be followed by a newline OR semicolon.     (If it's within other syntax, it must be placed on the line below the closing heredoc.
 *                                                        It can't even be followed by whitespace or a comment.)
 */
$simpleHeredoc =<<<SIMPLE
    This is a simple HEREDOC!
SIMPLE;

$inlineHereDoc = array(<<<EOD
value1,
value2,
value3,
value4
EOD
); // Both this closing syntax for the array and this comment must be placed below.
var_dump($inlineHereDoc);

$simpleHeredoc = <<<"StringSymbol"
Double quote strings are also valid
identification!
StringSymbol;


// NOWDOC
/**
 * Just like with single quoted strings, as explained before, nowdoc does not perform any evaluation;
 * allowing the use of symbols that would otherwise be treated as code.
 *
 * It's essentially the same as a Heredoc, with one quirk;
 * With no evaluation, it cannot evaluate an identification symbol, thus it must be identified by a
 * single quoted string instead.
 *
 * This quirk is used to differentiate between a NOWDOC and a HEREDOC.
 */
$simpleNowDoc = <<<'SIMPLE'
This is a $valid string literal.
Nothing will be evaluated!
Even \\ and \ !
SIMPLE;

// Arrays
/**
 * Inherently creates an array instance.
 */
$pandas = ['Lushui', 'Jasmina', 'Pali'];


/*
 * Some inert values.
 */
$one    = 1;
$two    = 2;
$three  = 3;

/**
 * Create an array of zval references.
 */
$variables = array($one, $two, $three);

/**
 * Creates an array instance with an api call to _types.array
 *
 * Members of the same array DO NOT have to have the same data type, unlike java.
 * Mix and match!
 */
$pandas = array($one, "yeet", 7, 3.2);

$_one        = $pandas[0];
$_yeet       = $pandas[1];
$_7          = $pandas[2];
$_3_2        = $pandas[3];

$outOfBounds = $pandas[4];
// Exception given => PHP Notice:  Undefined offset: 4 in <FILENAME> on line ##

/*
 * A Notice is not quite an error, but it's not ideal.
 * Unlike java, being out of bounds is not fatal if not handled - it's just dismissed.
 */

// Associative array. Similar to hash tables, values are associated with a key.
$numbers = [
    'one'       => 1,
    'two'       => 2,
    'three'     => 3,
    'four'      => 4,
    'five'      => 5,
    'six'       => 6
];

// These values cannot be gotten by index.
echo $numbers[0];
// PHP Notice:  Undefined offset: 0 in <FILENAME> on line ##

// Dump value by key
echo $numbers['three'];
// echo's "3".

// Multi dimentional
$numbers = [
    'prime'         => [2, 3, 5, 7, 11],
    'fibonacci'     => [1, 1, 2, 3, 5],
    'triangular'    => [1, 3, 6, 10, 15]
];

// First get the prime numbers array.
$primes = $numbers['prime'];

// Next get the third (second, zero-based) number.
echo $primes[2];

// Is the same as
echo $numbers['prime'][2];

/**
 * JS Foreach
 *
 * foreach (Source as Target.){}
 * Target can be preceeded by '&' to pass it as a refference, rather than a value.
 *
 */
$months = [];
foreach($months as $month){
    echo $month;
}

/**
 * Classing objects
 */

/**
 * Simple class.
 */
class PetName
{
    // Custom class property.
    private $pet_name;

    /**
     * Constructor
     *
     * Used to initalise this class instance, and prepare it for use.
     */
    public function __construct() {}

    /**
     * Deconstructor
     *
     * The antithesis of the construtor, used to tare down an instance.
     * Since PHP has a garbage collector, this doesn't have to be implemented in every class.
     *
     * It's intended use is for classes that require a graceful shutdown, for example because they're
     * using resources, or are running coroutines.
     *
     * The deconstructor would then be used to signal for its related processes to be stopped, and any resources
     * it's holding open, such as I/O streams or network connections, to be closed gracefully.
     */
    public function __destruct() {}

    /**
     * Mutator / Setter.
     *
     * From the object oriented paradigm, asserts local control
     * over the value within a private property.
     *
     * Mutators should always be used to unify any modifications that may be made
     * to a property later on, even if there is no unique functionality yet.
     */
    public function setPetName($pet_name_to_store)
    {
        $this->pet_name = $pet_name_to_store;
    }

    /**
     * Getter.
     *
     * Allows external reading of a private property.
     * @return mixed
     */
    public function getPetName()
    {
        return $this->pet_name;
    }
}

/**
 * Creating an object instance.
 *
 * Create a new variable token as you normally would in PHP,
 * then create a new object instance just like you would in Java
 * using the NEW keyword.
 *
 * Then we're storing the resulting object from the NEW
 * instance inside the token we just created.
 *
 * $variableToken = new PetName();
 */
$pet = new PetName();

/**
 * Accessing members
 *
 * In java, a period ( . ) is indicative of referencing a member within an object.
 * However, in PHP, a period is used for string concatenation only.
 *
 * This leaves PHP having to find another symbol to access object members,
 * settling with the two character lambda arrow ( -> ).
 *
 * JAVA : object.member
 * PHP  : object->member
 */
$pet -> setPetName("yeet");
