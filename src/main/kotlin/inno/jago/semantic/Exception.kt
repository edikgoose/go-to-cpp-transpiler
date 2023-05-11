package inno.jago.semantic

import inno.jago.ast.model.expression.ExpressionNode
import inno.jago.common.JaGoException
import inno.jago.lexer.Pos
import inno.jago.semantic.model.Type

open class SemanticException(msg: String) : JaGoException(msg)

class WrongTypeException(vararg expectedType: Type, actualType: Type, pos: Pos)
    : SemanticException("Expected [${expectedType.joinToString()}] type but got [$actualType] at $pos")

class NamedEntityAlreadyExistsException(identifier: String, pos: Pos)
    : SemanticException("Entity '$identifier' already exists at $pos")

class FuncEntityAlreadyExistsException(identifier: String, type: Type.FuncType, pos: Pos)
    : SemanticException("Function $identifier(${type.paramTypes.joinToString()}) at $pos")

class StructEntityAlreadyExistsException(identifier: String, type: Type.StructType, pos: Pos)
    : SemanticException("Struct $identifier(${type.fields}) at $pos")
class VarDeclMustPresentTypeOrExpressionException(varIdentifier: String, pos: Pos) : SemanticException(
    "The variable declaration '$varIdentifier' must specify the type or the assigned expression at $pos"
)

class ReturnInWrongScopeException(pos : Pos)
    : SemanticException("Return statement at $pos must be inside function scope")

class NoSuchEntityInCurrentScopeException(identifier: String, pos : Pos)
    : SemanticException("No such entity '$identifier' at $pos")

class NoSuchFunctionException(argTypes: List<Type>, pos : Pos)
    : SemanticException("No such function with argument types (${argTypes.joinToString()}) at $pos")

class NonCastableTypeException(from: Type, to: Type, pos: Pos)
    : SemanticException("Cannot cast from $from to $to at $pos")

class BreakIsNotInLoopException(pos: Pos)
    : SemanticException("break is not in a loop at $pos")

class ContinueIsNotInLoopException(pos: Pos)
    : SemanticException("continue is not in a loop at $pos")

class IsNotAssignableExpression(expression: ExpressionNode)
    : SemanticException("${expression.javaClass.simpleName} is not assignable at ${expression.pos}")
