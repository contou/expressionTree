package com.example.expressiontree.visitor;

import com.example.expressiontree.Platform;
import com.example.expressiontree.composite.CompositeAddNode;
import com.example.expressiontree.composite.CompositeDivideNode;
import com.example.expressiontree.composite.CompositeMultiplyNode;
import com.example.expressiontree.composite.CompositeNegateNode;
import com.example.expressiontree.composite.CompositeSubtractNode;
import com.example.expressiontree.composite.LeafNode;

/**
 * @class PrintVisitor
 *
 * @brief This class serves as a visitor that print the contents of
 *        each type of node in an expression tree.  This class plays
 *        the role of the "ConcreteVisitor" in the Visitor pattern.
 */
public class PrintVisitor implements Visitor
{
    /** Ctor */
    public PrintVisitor()
    {    
    }

    /** Visits a @a LeafNode and prints it contents. */
    public void visit(LeafNode node)
    {
        Platform.instance().outputString(node.item() + " " );
    }

    /** Visit a @a CompositeNegateNode and prints its contents. */
    public void visit(CompositeNegateNode node)
    {
        Platform.instance().outputString("-");
    }

    /** Visit a @a CompositeAddNode and prints its contents. */
    public void visit(CompositeAddNode node)
    {
        Platform.instance().outputString("+ ");
    }

    /** Visit a @a CompositeSubtractNode and prints its contents. */
    public void visit(CompositeSubtractNode node)
    {
        Platform.instance().outputString("- ");
    }

    /** Visit a @a CompositeDivideNode and prints its contents. */
    public void visit(CompositeDivideNode node)
    {
        Platform.instance().outputString("/ ");
    }

    /** Visit a @a CompositeMultiplyNode and print its contents. */
    public void visit(CompositeMultiplyNode node)
    {
        Platform.instance().outputString("* ");
    }
}
