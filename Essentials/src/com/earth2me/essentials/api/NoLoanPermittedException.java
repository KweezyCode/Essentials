package com.earth2me.essentials.api;

import static com.earth2me.essentials.I18n._;


public class NoLoanPermittedException extends Exception
{
	public NoLoanPermittedException()
	{
		super(_("negativeBalanceError"));
	}
}
