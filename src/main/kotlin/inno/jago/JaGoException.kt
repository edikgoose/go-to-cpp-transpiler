package inno.jago

import javax.naming.OperationNotSupportedException

sealed class JaGoException(msg: String) : Exception(msg)


class WrongNumberOfExpressions(expected: Int, actual: Int) : JaGoException(
    "Expected $expected or func expressions, got $actual expression"
)
class ConversionException(msg: String) : JaGoException(msg)

class EntityNotSupported(entityName: String) : JaGoException("$entityName are not supported")

class UnreachableCodeException : OperationNotSupportedException("Unreachable code")
