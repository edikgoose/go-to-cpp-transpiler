package inno.jago.converter.expression

import inno.jago.UnreachableCodeException
import inno.jago.ast.expression.unary_expression.UnaryExpressionNode
import inno.jago.ast.expression.unary_expression.UnaryOrPrimaryExpression
import inno.jago.converter.expression.primary_expression.toPrimaryExpressionNode
import inno.jago.converter.toPos

fun GoParser.UnaryExprContext.toUnaryOrPrimaryExpression(): UnaryOrPrimaryExpression {
    primaryExpr()?.let {
        return it.toPrimaryExpressionNode()
    }

    unaryExpr()?.let {
        return UnaryExpressionNode(
            toPos(),
            it.unary_op().toUnaryOperator(),
            it.toUnaryOrPrimaryExpression()
        )
    }

    throw UnreachableCodeException()
}



