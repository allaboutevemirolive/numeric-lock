def matches_in_place(a, b):
    """Returns a boolean array indicating if each element in a is in the same position as the corresponding element in b."""
    return [a[i] == b[i] for i in range(len(a))]

def num_matches_in_place(a, b):
    """Returns the number of elements in a that are in the same position as the corresponding element in b."""
    return sum(matches_in_place(a, b))

def num_digits_right(a, b):
    """Returns the number of elements in a that are also in b, regardless of position."""
    return len(set(a) & set(b))

def rule1(guess):
    """Returns True if the guess satisfies the first clue."""
    clue_combo = [6, 8, 2]
    return num_matches_in_place(guess, clue_combo) == 1 and num_digits_right(guess, clue_combo) == 1

def rule2(guess):
    """Returns True if the guess satisfies the second clue."""
    clue_combo = [6, 1, 4]
    return num_matches_in_place(guess, clue_combo) == 0 and num_digits_right(guess, clue_combo) == 1

def rule3(guess):
    """Returns True if the guess satisfies the third clue."""
    clue_combo = [2, 0, 6]
    return num_matches_in_place(guess, clue_combo) == 0 and num_digits_right(guess, clue_combo) == 2

def rule4(guess):
    """Returns True if the guess satisfies the fourth clue."""
    clue_combo = [7, 3, 8]
    return num_digits_right(guess, clue_combo) == 0

def rule5(guess):
    """Returns True if the guess satisfies the fifth clue."""
    clue_combo = [3, 8, 0]
    return num_matches_in_place(guess, clue_combo) == 0 and num_digits_right(guess, clue_combo) == 1

def print_guess(guess):
    """Prints the guess in the format 'a-b-c'."""
    print(f"{guess[0]}-{guess[1]}-{guess[2]}", end='')

def evaluate(guess):
    """Evaluates the guess against all five clues and prints the results."""
    print_guess(guess)
    print(':', end='')
    fails = 0
    if not rule1(guess):
        print('  !r1', end='')
        fails += 1
    if not rule2(guess):
        print('  !r2', end='')
        fails += 1
    if not rule3(guess):
        print('  !r3', end='')
        fails += 1
    if not rule4(guess):
        print('  !r4', end='')
        fails += 1
    if not rule5(guess):
        print('  !r5', end='')
        fails += 1
    if fails == 0:
        print(' OMG OK!!11!', end='')
    print()

valid_guesses = []
for i in range(10):
    for j in range(10):
        for k in range(10):
            guess = [i, j, k]
            if evaluate(guess):
                valid_guesses.append(guess)

if not valid_guesses:
    print('No valid guesses found. :(')
else:
    print('\nValid guesses:')
    for valid in valid_guesses:
        print_guess(valid)
        print()
