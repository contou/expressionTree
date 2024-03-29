package com.example.expressiontree.command;

import com.example.expressiontree.reactor.InputDispatcher;
import com.example.expressiontree.state.TreeOps;

/**
 * @class QuitCommand
 * 
 * @brief Instructs the input dispatching loop to shut down.  This
 *        plays the role of the "ConcreteCommand" in the Command
 *        pattern.
 */
public class QuitCommand extends UserCommand
{
    /** 
     * Constructor that provides the appropriate @a TreeOps.
     */
    public QuitCommand(TreeOps context)
    {
        super.treeOps = context;
    }

    /** Quit the input dispatching loop. */
    public void execute() 
    {
        InputDispatcher.instance().endInputDispatching();
    }

    /** Print the valid commands available to users. */
    public void printValidCommands(boolean verboseField) 
    {
    }
}
