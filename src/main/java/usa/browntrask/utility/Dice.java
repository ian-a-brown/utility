package usa.browntrask.utility;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Provides a set of dice and allows them to be rolled.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1 February 7, 2005
 * @version V2.2.0 Feb 28, 2015
 */
public final class Dice implements Serializable {

	/**
	 * the dice instances created based on particular strings.
	 * <p>
	 * 
	 * @since V0.1.2 December 12, 2006
	 * @version June 15, 2007
	 */
	private static Map<String, Dice> AvailableDice = new TreeMap<String, Dice>();

	/**
	 * the serial version ID for the class.
	 * <p>
	 * 
	 * @since V0.1 February 7, 2005
	 * @version December 12, 2006
	 */
	private static final long serialVersionUID = 6644838909251468252L;

	/**
	 * Gets an instance of a AvailableDice object for the specified description.
	 * <p>
	 * The instances are cached, so repeatedly asking for the same description will return the same AvailableDice object.
	 * <p>
	 * 
	 * @param diceDescription
	 *            the description of the dice.
	 * @return the dice.
	 * @since V0.1.2 December 12, 2006
	 * @version June 15, 2007
	 * @throws ParseException
	 *             if the input string does not have two tokens.
	 */
	public final static Dice getInstance(final String diceDescription) throws ParseException {
		return getInstance(diceDescription, new RandomNumberGeneratorImpl());
	}

	/**
	 * Gets an instance of a AvailableDice object for the specified description and using the specified random number generator.
	 * <p>
	 * The instances are cached, so repeatedly asking for the same description will return the same AvailableDice object.
	 * <p>
	 * 
	 * @param diceDescription
	 *            the description of the dice.
	 * @param random
	 *            the random number generator.
	 * @return the dice.
	 * @since V0.6.0 Mar 8, 2008
	 * @version Mar 8, 2008
	 * @throws ParseException
	 *             if the input string does not have two tokens.
	 */
	public final static Dice getInstance(final String diceDescription, final RandomNumberGenerator random) throws ParseException {
		Dice dice;
		synchronized (AvailableDice) {
			dice = AvailableDice.get(diceDescription);
			if (dice == null) {
				dice = new Dice(diceDescription);
				AvailableDice.put(diceDescription, dice);
			}
			dice.setRandom(random);
		}

		return dice;
	}

	/**
	 * the number of dice in this set.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1 February 7, 2005
	 * @version December 12, 2006
	 */
	private int numberDice = 0;

	/**
	 * the number of sides on each die.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1 February 7, 2005
	 * @version December 12, 2006
	 */
	private int numberSides = 0;

	/**
	 * the random number generator.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1 February 7, 2005
	 * @version Mar 8, 2008
	 */
	private transient RandomNumberGenerator random = null;

	/**
	 * Builds a new set of dice.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1 February 7, 2005
	 * @version December 12, 2006
	 */
	public Dice() {
		super();
	}

	/**
	 * Builds a new set of dice containing the specified number of dice each with the number of sides.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param numberDice
	 *            the number of dice in the set.
	 * @param numberSides
	 *            the number of sides on each die.
	 * @since V0.1 February 7, 2005
	 * @version Aug 19, 2007
	 */
	public Dice(final int numberDice, final int numberSides) {
		this();

		setNumberSides(numberSides);
		setNumberDice(numberDice);
	}

	/**
	 * Builds a new set of dice for the input description.
	 * <p>
	 * 
	 * @param diceDescription
	 *            the description of the dice.
	 * @since V0.1.2 December 12, 2006
	 * @version Aug 19, 2007
	 * @throws ParseException
	 *             if the input string does not have two tokens.
	 */
	public Dice(final String diceDescription) throws ParseException {
		super();
		parse(diceDescription);
	}

	/**
	 * Gets the number of dice in this set.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the number of dice.
	 * @since V0.1 February 7, 2005
	 * @version June 15, 2007
	 */
	public final int getNumberDice() {
		return numberDice;
	}

	/**
	 * Gets the number of sides on a single die.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the number of sides.
	 * @since V0.1 February 7, 2005
	 * @version June 15, 2007
	 */
	public final int getNumberSides() {
		return numberSides;
	}

	/**
	 * Parses the input dice description to set the number of dice and sides.
	 * <p>
	 * The expression should be of the form:
	 * <p>
	 * &lt;# dice&gt;D&lt;# sides&gt;
	 * <p>
	 * 
	 * @param diceDescription
	 *            the description of the dice.
	 * @since V0.1.2 December 12, 2006
	 * @version June 15, 2007
	 * @throws ParseException
	 *             if the input string does not have two tokens.
	 */
	public final void parse(final String diceDescription) throws ParseException {
		final StringTokenizer stok = new StringTokenizer(diceDescription, "dD");
		if (stok.countTokens() != 2) {
			throw new ParseException(diceDescription + " is not a valid dice description. Must be of the form <# dice>D<# sides>",
					0);
		}

		setNumberDice(Integer.parseInt(stok.nextToken()));
		setNumberSides(Integer.parseInt(stok.nextToken()));
	}

	/**
	 * Rolls the dice.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return the roll.
	 * @since V0.1 February 7, 2005
	 * @version Mar 8, 2008
	 */
	public final int roll() {
		if (random == null) {
			setRandom(new RandomNumberGeneratorImpl(System.currentTimeMillis()));
		}

		int totalR = 0;

		for (int idx = 0; idx < getNumberDice(); ++idx) {
			totalR += 1 + random.nextInt(getNumberSides());
		}

		return totalR;
	}

	/**
	 * Sets the number of dice in this set.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param numberDice
	 *            the number of dice.
	 * @since V0.1 February 7, 2005
	 * @version June 15, 2007
	 */
	public final void setNumberDice(final int numberDice) {
		if (numberDice <= 0) {
			throw new IllegalArgumentException("The number of dice in a set must be positive.");
		}

		this.numberDice = numberDice;
	}

	/**
	 * Sets the number of sides on a die.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param numberSides
	 *            the number of sides on a single die.
	 * @since V0.1 February 7, 2005
	 * @version June 15, 2007
	 */
	public final void setNumberSides(final int numberSides) {
		if (numberSides <= 0) {
			throw new IllegalArgumentException("The number of sides on a die in a set must be positive.");
		}

		this.numberSides = numberSides;
	}

	/**
	 * Sets the random number generator.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @param random
	 *            the random number generator.
	 * @since V0.1 February 7, 2005
	 * @version Mar 8, 2008
	 */
	public final void setRandom(final RandomNumberGenerator random) {
		this.random = random;
	}

	/** {@inheritDoc} */
	@Override
	public final String toString() {
		return "AvailableDice: " + getNumberDice() + "d" + getNumberSides();
	}
}
