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
// Exception given => PHP Notice:  Undefined offset: 4 in <FILENAME> on line 33

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
// PHP Notice:  Undefined offset: 0 in <FILENAME> on line 101

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
echo $primes['prime'][2];

/**
 * JS Foreach
 * 
 * foreach (Source as Target.){}
 * Target can be preceeded by '&' to pass it as a refference, rather than a value.
 * 
 */
foreach($months as &$month){
    echo $month;
}