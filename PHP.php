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

$numbers = [
    'one'       => 1,
    'two'       => 2,
    'three'     => 3,
    'four'      => 4,
    'five'      => 5,
    'six'       => 6
];