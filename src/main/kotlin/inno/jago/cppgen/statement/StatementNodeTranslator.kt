package inno.jago.cppgen.statement

import inno.jago.ast.model.statement.BlockStatementNode
import inno.jago.ast.model.statement.BreakStatementNode
import inno.jago.ast.model.statement.ContinueStatementNode
import inno.jago.ast.model.statement.DeclarationStatementNode
import inno.jago.ast.model.statement.ElseStatementNode
import inno.jago.ast.model.statement.ForStatementNode
import inno.jago.ast.model.statement.IfStatementNode
import inno.jago.ast.model.statement.ReturnStatementNode
import inno.jago.ast.model.statement.SimpleStatementNode
import inno.jago.ast.model.statement.StatementNode

fun StatementNode.translateToCode(): String {
    val instruction = when (this) {
        is BlockStatementNode -> {
            TODO()
        }
        is DeclarationStatementNode -> {
            TODO()
        }
        is ReturnStatementNode -> {
            TODO()
        }
        is BreakStatementNode -> {
            "break;"
        }
        is ContinueStatementNode -> {
            "continue;"
        }
        is IfStatementNode -> {
            TODO()
        }
        is ElseStatementNode -> {
            translateToCode()
        }
        is ForStatementNode -> {
            translateToCode()
        }
        is SimpleStatementNode -> {
            translateToCode()
        }
        else -> ""
    }

    return instruction
}
