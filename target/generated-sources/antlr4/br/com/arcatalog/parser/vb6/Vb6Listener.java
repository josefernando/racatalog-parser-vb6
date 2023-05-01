// Generated from br\com\arcatalog\parser\vb6\Vb6.g4 by ANTLR 4.12.0
package br.com.arcatalog.parser.vb6;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Vb6Parser}.
 */
public interface Vb6Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#startRule}.
	 * @param ctx the parse tree
	 */
	void enterStartRule(Vb6Parser.StartRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#startRule}.
	 * @param ctx the parse tree
	 */
	void exitStartRule(Vb6Parser.StartRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(Vb6Parser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(Vb6Parser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(Vb6Parser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(Vb6Parser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#moduleHeader}.
	 * @param ctx the parse tree
	 */
	void enterModuleHeader(Vb6Parser.ModuleHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#moduleHeader}.
	 * @param ctx the parse tree
	 */
	void exitModuleHeader(Vb6Parser.ModuleHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#moduleReferences}.
	 * @param ctx the parse tree
	 */
	void enterModuleReferences(Vb6Parser.ModuleReferencesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#moduleReferences}.
	 * @param ctx the parse tree
	 */
	void exitModuleReferences(Vb6Parser.ModuleReferencesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#moduleReferenceStmt}.
	 * @param ctx the parse tree
	 */
	void enterModuleReferenceStmt(Vb6Parser.ModuleReferenceStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#moduleReferenceStmt}.
	 * @param ctx the parse tree
	 */
	void exitModuleReferenceStmt(Vb6Parser.ModuleReferenceStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#referenceType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceType(Vb6Parser.ReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#referenceType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceType(Vb6Parser.ReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#moduleUI}.
	 * @param ctx the parse tree
	 */
	void enterModuleUI(Vb6Parser.ModuleUIContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#moduleUI}.
	 * @param ctx the parse tree
	 */
	void exitModuleUI(Vb6Parser.ModuleUIContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#guiDefinition}.
	 * @param ctx the parse tree
	 */
	void enterGuiDefinition(Vb6Parser.GuiDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#guiDefinition}.
	 * @param ctx the parse tree
	 */
	void exitGuiDefinition(Vb6Parser.GuiDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#designerHKLM}.
	 * @param ctx the parse tree
	 */
	void enterDesignerHKLM(Vb6Parser.DesignerHKLMContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#designerHKLM}.
	 * @param ctx the parse tree
	 */
	void exitDesignerHKLM(Vb6Parser.DesignerHKLMContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#guiAttributeSetting}.
	 * @param ctx the parse tree
	 */
	void enterGuiAttributeSetting(Vb6Parser.GuiAttributeSettingContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#guiAttributeSetting}.
	 * @param ctx the parse tree
	 */
	void exitGuiAttributeSetting(Vb6Parser.GuiAttributeSettingContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#guiProperty}.
	 * @param ctx the parse tree
	 */
	void enterGuiProperty(Vb6Parser.GuiPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#guiProperty}.
	 * @param ctx the parse tree
	 */
	void exitGuiProperty(Vb6Parser.GuiPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#directiveSection}.
	 * @param ctx the parse tree
	 */
	void enterDirectiveSection(Vb6Parser.DirectiveSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#directiveSection}.
	 * @param ctx the parse tree
	 */
	void exitDirectiveSection(Vb6Parser.DirectiveSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#definitionSection}.
	 * @param ctx the parse tree
	 */
	void enterDefinitionSection(Vb6Parser.DefinitionSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#definitionSection}.
	 * @param ctx the parse tree
	 */
	void exitDefinitionSection(Vb6Parser.DefinitionSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#definitionInMethod}.
	 * @param ctx the parse tree
	 */
	void enterDefinitionInMethod(Vb6Parser.DefinitionInMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#definitionInMethod}.
	 * @param ctx the parse tree
	 */
	void exitDefinitionInMethod(Vb6Parser.DefinitionInMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#enumerationDefinition}.
	 * @param ctx the parse tree
	 */
	void enterEnumerationDefinition(Vb6Parser.EnumerationDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#enumerationDefinition}.
	 * @param ctx the parse tree
	 */
	void exitEnumerationDefinition(Vb6Parser.EnumerationDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#enumValues}.
	 * @param ctx the parse tree
	 */
	void enterEnumValues(Vb6Parser.EnumValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#enumValues}.
	 * @param ctx the parse tree
	 */
	void exitEnumValues(Vb6Parser.EnumValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#methodDefinition}.
	 * @param ctx the parse tree
	 */
	void enterMethodDefinition(Vb6Parser.MethodDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#methodDefinition}.
	 * @param ctx the parse tree
	 */
	void exitMethodDefinition(Vb6Parser.MethodDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#endSub}.
	 * @param ctx the parse tree
	 */
	void enterEndSub(Vb6Parser.EndSubContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#endSub}.
	 * @param ctx the parse tree
	 */
	void exitEndSub(Vb6Parser.EndSubContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#endFunction}.
	 * @param ctx the parse tree
	 */
	void enterEndFunction(Vb6Parser.EndFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#endFunction}.
	 * @param ctx the parse tree
	 */
	void exitEndFunction(Vb6Parser.EndFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#endProperty}.
	 * @param ctx the parse tree
	 */
	void enterEndProperty(Vb6Parser.EndPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#endProperty}.
	 * @param ctx the parse tree
	 */
	void exitEndProperty(Vb6Parser.EndPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(Vb6Parser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(Vb6Parser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#variableListStmt}.
	 * @param ctx the parse tree
	 */
	void enterVariableListStmt(Vb6Parser.VariableListStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#variableListStmt}.
	 * @param ctx the parse tree
	 */
	void exitVariableListStmt(Vb6Parser.VariableListStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#variableStmt}.
	 * @param ctx the parse tree
	 */
	void enterVariableStmt(Vb6Parser.VariableStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#variableStmt}.
	 * @param ctx the parse tree
	 */
	void exitVariableStmt(Vb6Parser.VariableStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterTypeDefinition(Vb6Parser.TypeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitTypeDefinition(Vb6Parser.TypeDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void enterAccessModifier(Vb6Parser.AccessModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void exitAccessModifier(Vb6Parser.AccessModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#visibility}.
	 * @param ctx the parse tree
	 */
	void enterVisibility(Vb6Parser.VisibilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#visibility}.
	 * @param ctx the parse tree
	 */
	void exitVisibility(Vb6Parser.VisibilityContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#methodType}.
	 * @param ctx the parse tree
	 */
	void enterMethodType(Vb6Parser.MethodTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#methodType}.
	 * @param ctx the parse tree
	 */
	void exitMethodType(Vb6Parser.MethodTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#asTypeClause}.
	 * @param ctx the parse tree
	 */
	void enterAsTypeClause(Vb6Parser.AsTypeClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#asTypeClause}.
	 * @param ctx the parse tree
	 */
	void exitAsTypeClause(Vb6Parser.AsTypeClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(Vb6Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(Vb6Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#builtinType}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinType(Vb6Parser.BuiltinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#builtinType}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinType(Vb6Parser.BuiltinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#fieldLength}.
	 * @param ctx the parse tree
	 */
	void enterFieldLength(Vb6Parser.FieldLengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#fieldLength}.
	 * @param ctx the parse tree
	 */
	void exitFieldLength(Vb6Parser.FieldLengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#initialValue}.
	 * @param ctx the parse tree
	 */
	void enterInitialValue(Vb6Parser.InitialValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#initialValue}.
	 * @param ctx the parse tree
	 */
	void exitInitialValue(Vb6Parser.InitialValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#subscripts}.
	 * @param ctx the parse tree
	 */
	void enterSubscripts(Vb6Parser.SubscriptsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#subscripts}.
	 * @param ctx the parse tree
	 */
	void exitSubscripts(Vb6Parser.SubscriptsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#subscript}.
	 * @param ctx the parse tree
	 */
	void enterSubscript(Vb6Parser.SubscriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#subscript}.
	 * @param ctx the parse tree
	 */
	void exitSubscript(Vb6Parser.SubscriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#optionStmt}.
	 * @param ctx the parse tree
	 */
	void enterOptionStmt(Vb6Parser.OptionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#optionStmt}.
	 * @param ctx the parse tree
	 */
	void exitOptionStmt(Vb6Parser.OptionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#attributeStmt}.
	 * @param ctx the parse tree
	 */
	void enterAttributeStmt(Vb6Parser.AttributeStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#attributeStmt}.
	 * @param ctx the parse tree
	 */
	void exitAttributeStmt(Vb6Parser.AttributeStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#defTypeStmt}.
	 * @param ctx the parse tree
	 */
	void enterDefTypeStmt(Vb6Parser.DefTypeStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#defTypeStmt}.
	 * @param ctx the parse tree
	 */
	void exitDefTypeStmt(Vb6Parser.DefTypeStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#defType}.
	 * @param ctx the parse tree
	 */
	void enterDefType(Vb6Parser.DefTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#defType}.
	 * @param ctx the parse tree
	 */
	void exitDefType(Vb6Parser.DefTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#directiveBlock}.
	 * @param ctx the parse tree
	 */
	void enterDirectiveBlock(Vb6Parser.DirectiveBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#directiveBlock}.
	 * @param ctx the parse tree
	 */
	void exitDirectiveBlock(Vb6Parser.DirectiveBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#blockStmt}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(Vb6Parser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#blockStmt}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(Vb6Parser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(Vb6Parser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(Vb6Parser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#assignmentStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStmt(Vb6Parser.AssignmentStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#assignmentStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStmt(Vb6Parser.AssignmentStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#implicitCallStmt}.
	 * @param ctx the parse tree
	 */
	void enterImplicitCallStmt(Vb6Parser.ImplicitCallStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#implicitCallStmt}.
	 * @param ctx the parse tree
	 */
	void exitImplicitCallStmt(Vb6Parser.ImplicitCallStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#commandStmt}.
	 * @param ctx the parse tree
	 */
	void enterCommandStmt(Vb6Parser.CommandStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#commandStmt}.
	 * @param ctx the parse tree
	 */
	void exitCommandStmt(Vb6Parser.CommandStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#appactivateStmt}.
	 * @param ctx the parse tree
	 */
	void enterAppactivateStmt(Vb6Parser.AppactivateStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#appactivateStmt}.
	 * @param ctx the parse tree
	 */
	void exitAppactivateStmt(Vb6Parser.AppactivateStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#callStmt}.
	 * @param ctx the parse tree
	 */
	void enterCallStmt(Vb6Parser.CallStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#callStmt}.
	 * @param ctx the parse tree
	 */
	void exitCallStmt(Vb6Parser.CallStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#chdirStmt}.
	 * @param ctx the parse tree
	 */
	void enterChdirStmt(Vb6Parser.ChdirStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#chdirStmt}.
	 * @param ctx the parse tree
	 */
	void exitChdirStmt(Vb6Parser.ChdirStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#closeStmt}.
	 * @param ctx the parse tree
	 */
	void enterCloseStmt(Vb6Parser.CloseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#closeStmt}.
	 * @param ctx the parse tree
	 */
	void exitCloseStmt(Vb6Parser.CloseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#declareStmt}.
	 * @param ctx the parse tree
	 */
	void enterDeclareStmt(Vb6Parser.DeclareStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#declareStmt}.
	 * @param ctx the parse tree
	 */
	void exitDeclareStmt(Vb6Parser.DeclareStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#library}.
	 * @param ctx the parse tree
	 */
	void enterLibrary(Vb6Parser.LibraryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#library}.
	 * @param ctx the parse tree
	 */
	void exitLibrary(Vb6Parser.LibraryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#alias}.
	 * @param ctx the parse tree
	 */
	void enterAlias(Vb6Parser.AliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#alias}.
	 * @param ctx the parse tree
	 */
	void exitAlias(Vb6Parser.AliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#eventStmt}.
	 * @param ctx the parse tree
	 */
	void enterEventStmt(Vb6Parser.EventStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#eventStmt}.
	 * @param ctx the parse tree
	 */
	void exitEventStmt(Vb6Parser.EventStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#doEvents}.
	 * @param ctx the parse tree
	 */
	void enterDoEvents(Vb6Parser.DoEventsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#doEvents}.
	 * @param ctx the parse tree
	 */
	void exitDoEvents(Vb6Parser.DoEventsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#endStmt}.
	 * @param ctx the parse tree
	 */
	void enterEndStmt(Vb6Parser.EndStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#endStmt}.
	 * @param ctx the parse tree
	 */
	void exitEndStmt(Vb6Parser.EndStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#eraseStmt}.
	 * @param ctx the parse tree
	 */
	void enterEraseStmt(Vb6Parser.EraseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#eraseStmt}.
	 * @param ctx the parse tree
	 */
	void exitEraseStmt(Vb6Parser.EraseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#exitStmt}.
	 * @param ctx the parse tree
	 */
	void enterExitStmt(Vb6Parser.ExitStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#exitStmt}.
	 * @param ctx the parse tree
	 */
	void exitExitStmt(Vb6Parser.ExitStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#exitDo}.
	 * @param ctx the parse tree
	 */
	void enterExitDo(Vb6Parser.ExitDoContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#exitDo}.
	 * @param ctx the parse tree
	 */
	void exitExitDo(Vb6Parser.ExitDoContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#exitFor}.
	 * @param ctx the parse tree
	 */
	void enterExitFor(Vb6Parser.ExitForContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#exitFor}.
	 * @param ctx the parse tree
	 */
	void exitExitFor(Vb6Parser.ExitForContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#exitFunction}.
	 * @param ctx the parse tree
	 */
	void enterExitFunction(Vb6Parser.ExitFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#exitFunction}.
	 * @param ctx the parse tree
	 */
	void exitExitFunction(Vb6Parser.ExitFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#exitProperty}.
	 * @param ctx the parse tree
	 */
	void enterExitProperty(Vb6Parser.ExitPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#exitProperty}.
	 * @param ctx the parse tree
	 */
	void exitExitProperty(Vb6Parser.ExitPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#exitSub}.
	 * @param ctx the parse tree
	 */
	void enterExitSub(Vb6Parser.ExitSubContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#exitSub}.
	 * @param ctx the parse tree
	 */
	void exitExitSub(Vb6Parser.ExitSubContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#getStmt}.
	 * @param ctx the parse tree
	 */
	void enterGetStmt(Vb6Parser.GetStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#getStmt}.
	 * @param ctx the parse tree
	 */
	void exitGetStmt(Vb6Parser.GetStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#goSubStmt}.
	 * @param ctx the parse tree
	 */
	void enterGoSubStmt(Vb6Parser.GoSubStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#goSubStmt}.
	 * @param ctx the parse tree
	 */
	void exitGoSubStmt(Vb6Parser.GoSubStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#ifThenElseStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStmt(Vb6Parser.IfThenElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#ifThenElseStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStmt(Vb6Parser.IfThenElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#ifBodyInLine}.
	 * @param ctx the parse tree
	 */
	void enterIfBodyInLine(Vb6Parser.IfBodyInLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#ifBodyInLine}.
	 * @param ctx the parse tree
	 */
	void exitIfBodyInLine(Vb6Parser.IfBodyInLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#ifBodyInBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfBodyInBlock(Vb6Parser.IfBodyInBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#ifBodyInBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfBodyInBlock(Vb6Parser.IfBodyInBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#endIf}.
	 * @param ctx the parse tree
	 */
	void enterEndIf(Vb6Parser.EndIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#endIf}.
	 * @param ctx the parse tree
	 */
	void exitEndIf(Vb6Parser.EndIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#ifDirective}.
	 * @param ctx the parse tree
	 */
	void enterIfDirective(Vb6Parser.IfDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#ifDirective}.
	 * @param ctx the parse tree
	 */
	void exitIfDirective(Vb6Parser.IfDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#ifBodyInBlockDirective}.
	 * @param ctx the parse tree
	 */
	void enterIfBodyInBlockDirective(Vb6Parser.IfBodyInBlockDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#ifBodyInBlockDirective}.
	 * @param ctx the parse tree
	 */
	void exitIfBodyInBlockDirective(Vb6Parser.IfBodyInBlockDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#conditionalExpr}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpr(Vb6Parser.ConditionalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#conditionalExpr}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpr(Vb6Parser.ConditionalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#ifTrue}.
	 * @param ctx the parse tree
	 */
	void enterIfTrue(Vb6Parser.IfTrueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#ifTrue}.
	 * @param ctx the parse tree
	 */
	void exitIfTrue(Vb6Parser.IfTrueContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#ifTrueElseIf}.
	 * @param ctx the parse tree
	 */
	void enterIfTrueElseIf(Vb6Parser.IfTrueElseIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#ifTrueElseIf}.
	 * @param ctx the parse tree
	 */
	void exitIfTrueElseIf(Vb6Parser.IfTrueElseIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#ifTrueInLine}.
	 * @param ctx the parse tree
	 */
	void enterIfTrueInLine(Vb6Parser.IfTrueInLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#ifTrueInLine}.
	 * @param ctx the parse tree
	 */
	void exitIfTrueInLine(Vb6Parser.IfTrueInLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#elseIf}.
	 * @param ctx the parse tree
	 */
	void enterElseIf(Vb6Parser.ElseIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#elseIf}.
	 * @param ctx the parse tree
	 */
	void exitElseIf(Vb6Parser.ElseIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#ifFalse}.
	 * @param ctx the parse tree
	 */
	void enterIfFalse(Vb6Parser.IfFalseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#ifFalse}.
	 * @param ctx the parse tree
	 */
	void exitIfFalse(Vb6Parser.IfFalseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#ifFalseInLine}.
	 * @param ctx the parse tree
	 */
	void enterIfFalseInLine(Vb6Parser.IfFalseInLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#ifFalseInLine}.
	 * @param ctx the parse tree
	 */
	void exitIfFalseInLine(Vb6Parser.IfFalseInLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#elseIfDirective}.
	 * @param ctx the parse tree
	 */
	void enterElseIfDirective(Vb6Parser.ElseIfDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#elseIfDirective}.
	 * @param ctx the parse tree
	 */
	void exitElseIfDirective(Vb6Parser.ElseIfDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#elseDirective}.
	 * @param ctx the parse tree
	 */
	void enterElseDirective(Vb6Parser.ElseDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#elseDirective}.
	 * @param ctx the parse tree
	 */
	void exitElseDirective(Vb6Parser.ElseDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#filecopyStmt}.
	 * @param ctx the parse tree
	 */
	void enterFilecopyStmt(Vb6Parser.FilecopyStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#filecopyStmt}.
	 * @param ctx the parse tree
	 */
	void exitFilecopyStmt(Vb6Parser.FilecopyStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(Vb6Parser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(Vb6Parser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#forEachStmt}.
	 * @param ctx the parse tree
	 */
	void enterForEachStmt(Vb6Parser.ForEachStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#forEachStmt}.
	 * @param ctx the parse tree
	 */
	void exitForEachStmt(Vb6Parser.ForEachStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#forNextStmt}.
	 * @param ctx the parse tree
	 */
	void enterForNextStmt(Vb6Parser.ForNextStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#forNextStmt}.
	 * @param ctx the parse tree
	 */
	void exitForNextStmt(Vb6Parser.ForNextStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#endFor}.
	 * @param ctx the parse tree
	 */
	void enterEndFor(Vb6Parser.EndForContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#endFor}.
	 * @param ctx the parse tree
	 */
	void exitEndFor(Vb6Parser.EndForContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#goToStmt}.
	 * @param ctx the parse tree
	 */
	void enterGoToStmt(Vb6Parser.GoToStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#goToStmt}.
	 * @param ctx the parse tree
	 */
	void exitGoToStmt(Vb6Parser.GoToStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#lineInputStmt}.
	 * @param ctx the parse tree
	 */
	void enterLineInputStmt(Vb6Parser.LineInputStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#lineInputStmt}.
	 * @param ctx the parse tree
	 */
	void exitLineInputStmt(Vb6Parser.LineInputStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#inputStmt}.
	 * @param ctx the parse tree
	 */
	void enterInputStmt(Vb6Parser.InputStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#inputStmt}.
	 * @param ctx the parse tree
	 */
	void exitInputStmt(Vb6Parser.InputStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#loadStmt}.
	 * @param ctx the parse tree
	 */
	void enterLoadStmt(Vb6Parser.LoadStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#loadStmt}.
	 * @param ctx the parse tree
	 */
	void exitLoadStmt(Vb6Parser.LoadStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#killStmt}.
	 * @param ctx the parse tree
	 */
	void enterKillStmt(Vb6Parser.KillStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#killStmt}.
	 * @param ctx the parse tree
	 */
	void exitKillStmt(Vb6Parser.KillStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#doLoopStmt}.
	 * @param ctx the parse tree
	 */
	void enterDoLoopStmt(Vb6Parser.DoLoopStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#doLoopStmt}.
	 * @param ctx the parse tree
	 */
	void exitDoLoopStmt(Vb6Parser.DoLoopStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#doInconditional}.
	 * @param ctx the parse tree
	 */
	void enterDoInconditional(Vb6Parser.DoInconditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#doInconditional}.
	 * @param ctx the parse tree
	 */
	void exitDoInconditional(Vb6Parser.DoInconditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#printStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(Vb6Parser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#printStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(Vb6Parser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#whileDo}.
	 * @param ctx the parse tree
	 */
	void enterWhileDo(Vb6Parser.WhileDoContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#whileDo}.
	 * @param ctx the parse tree
	 */
	void exitWhileDo(Vb6Parser.WhileDoContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#doUntil}.
	 * @param ctx the parse tree
	 */
	void enterDoUntil(Vb6Parser.DoUntilContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#doUntil}.
	 * @param ctx the parse tree
	 */
	void exitDoUntil(Vb6Parser.DoUntilContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#endLoop}.
	 * @param ctx the parse tree
	 */
	void enterEndLoop(Vb6Parser.EndLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#endLoop}.
	 * @param ctx the parse tree
	 */
	void exitEndLoop(Vb6Parser.EndLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#mkdirStmt}.
	 * @param ctx the parse tree
	 */
	void enterMkdirStmt(Vb6Parser.MkdirStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#mkdirStmt}.
	 * @param ctx the parse tree
	 */
	void exitMkdirStmt(Vb6Parser.MkdirStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#nameStmt}.
	 * @param ctx the parse tree
	 */
	void enterNameStmt(Vb6Parser.NameStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#nameStmt}.
	 * @param ctx the parse tree
	 */
	void exitNameStmt(Vb6Parser.NameStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#onErrorStmt}.
	 * @param ctx the parse tree
	 */
	void enterOnErrorStmt(Vb6Parser.OnErrorStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#onErrorStmt}.
	 * @param ctx the parse tree
	 */
	void exitOnErrorStmt(Vb6Parser.OnErrorStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#openStmt}.
	 * @param ctx the parse tree
	 */
	void enterOpenStmt(Vb6Parser.OpenStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#openStmt}.
	 * @param ctx the parse tree
	 */
	void exitOpenStmt(Vb6Parser.OpenStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#putStmt}.
	 * @param ctx the parse tree
	 */
	void enterPutStmt(Vb6Parser.PutStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#putStmt}.
	 * @param ctx the parse tree
	 */
	void exitPutStmt(Vb6Parser.PutStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#raiseEventStmt}.
	 * @param ctx the parse tree
	 */
	void enterRaiseEventStmt(Vb6Parser.RaiseEventStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#raiseEventStmt}.
	 * @param ctx the parse tree
	 */
	void exitRaiseEventStmt(Vb6Parser.RaiseEventStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#randomizeStmt}.
	 * @param ctx the parse tree
	 */
	void enterRandomizeStmt(Vb6Parser.RandomizeStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#randomizeStmt}.
	 * @param ctx the parse tree
	 */
	void exitRandomizeStmt(Vb6Parser.RandomizeStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#redimStmt}.
	 * @param ctx the parse tree
	 */
	void enterRedimStmt(Vb6Parser.RedimStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#redimStmt}.
	 * @param ctx the parse tree
	 */
	void exitRedimStmt(Vb6Parser.RedimStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#rmdirStmt}.
	 * @param ctx the parse tree
	 */
	void enterRmdirStmt(Vb6Parser.RmdirStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#rmdirStmt}.
	 * @param ctx the parse tree
	 */
	void exitRmdirStmt(Vb6Parser.RmdirStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#rsetStmt}.
	 * @param ctx the parse tree
	 */
	void enterRsetStmt(Vb6Parser.RsetStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#rsetStmt}.
	 * @param ctx the parse tree
	 */
	void exitRsetStmt(Vb6Parser.RsetStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#resumeStmt}.
	 * @param ctx the parse tree
	 */
	void enterResumeStmt(Vb6Parser.ResumeStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#resumeStmt}.
	 * @param ctx the parse tree
	 */
	void exitResumeStmt(Vb6Parser.ResumeStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#selectCaseStmt}.
	 * @param ctx the parse tree
	 */
	void enterSelectCaseStmt(Vb6Parser.SelectCaseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#selectCaseStmt}.
	 * @param ctx the parse tree
	 */
	void exitSelectCaseStmt(Vb6Parser.SelectCaseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#endSelect}.
	 * @param ctx the parse tree
	 */
	void enterEndSelect(Vb6Parser.EndSelectContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#endSelect}.
	 * @param ctx the parse tree
	 */
	void exitEndSelect(Vb6Parser.EndSelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#sC_Case}.
	 * @param ctx the parse tree
	 */
	void enterSC_Case(Vb6Parser.SC_CaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#sC_Case}.
	 * @param ctx the parse tree
	 */
	void exitSC_Case(Vb6Parser.SC_CaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#sC_Cond}.
	 * @param ctx the parse tree
	 */
	void enterSC_Cond(Vb6Parser.SC_CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#sC_Cond}.
	 * @param ctx the parse tree
	 */
	void exitSC_Cond(Vb6Parser.SC_CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#sendkeysStmt}.
	 * @param ctx the parse tree
	 */
	void enterSendkeysStmt(Vb6Parser.SendkeysStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#sendkeysStmt}.
	 * @param ctx the parse tree
	 */
	void exitSendkeysStmt(Vb6Parser.SendkeysStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#setattrStmt}.
	 * @param ctx the parse tree
	 */
	void enterSetattrStmt(Vb6Parser.SetattrStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#setattrStmt}.
	 * @param ctx the parse tree
	 */
	void exitSetattrStmt(Vb6Parser.SetattrStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#setStmt}.
	 * @param ctx the parse tree
	 */
	void enterSetStmt(Vb6Parser.SetStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#setStmt}.
	 * @param ctx the parse tree
	 */
	void exitSetStmt(Vb6Parser.SetStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#stopStmt}.
	 * @param ctx the parse tree
	 */
	void enterStopStmt(Vb6Parser.StopStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#stopStmt}.
	 * @param ctx the parse tree
	 */
	void exitStopStmt(Vb6Parser.StopStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#unloadStmt}.
	 * @param ctx the parse tree
	 */
	void enterUnloadStmt(Vb6Parser.UnloadStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#unloadStmt}.
	 * @param ctx the parse tree
	 */
	void exitUnloadStmt(Vb6Parser.UnloadStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#whileWendStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileWendStmt(Vb6Parser.WhileWendStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#whileWendStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileWendStmt(Vb6Parser.WhileWendStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#whileEnd}.
	 * @param ctx the parse tree
	 */
	void enterWhileEnd(Vb6Parser.WhileEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#whileEnd}.
	 * @param ctx the parse tree
	 */
	void exitWhileEnd(Vb6Parser.WhileEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#withStmt}.
	 * @param ctx the parse tree
	 */
	void enterWithStmt(Vb6Parser.WithStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#withStmt}.
	 * @param ctx the parse tree
	 */
	void exitWithStmt(Vb6Parser.WithStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void enterWriteStmt(Vb6Parser.WriteStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void exitWriteStmt(Vb6Parser.WriteStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#endOfLine}.
	 * @param ctx the parse tree
	 */
	void enterEndOfLine(Vb6Parser.EndOfLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#endOfLine}.
	 * @param ctx the parse tree
	 */
	void exitEndOfLine(Vb6Parser.EndOfLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#endOfStmt}.
	 * @param ctx the parse tree
	 */
	void enterEndOfStmt(Vb6Parser.EndOfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#endOfStmt}.
	 * @param ctx the parse tree
	 */
	void exitEndOfStmt(Vb6Parser.EndOfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(Vb6Parser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(Vb6Parser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(Vb6Parser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(Vb6Parser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#realParameters}.
	 * @param ctx the parse tree
	 */
	void enterRealParameters(Vb6Parser.RealParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#realParameters}.
	 * @param ctx the parse tree
	 */
	void exitRealParameters(Vb6Parser.RealParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#realParameter}.
	 * @param ctx the parse tree
	 */
	void enterRealParameter(Vb6Parser.RealParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#realParameter}.
	 * @param ctx the parse tree
	 */
	void exitRealParameter(Vb6Parser.RealParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(Vb6Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(Vb6Parser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#booleanExpr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpr(Vb6Parser.BooleanExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#booleanExpr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpr(Vb6Parser.BooleanExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#arithExpr}.
	 * @param ctx the parse tree
	 */
	void enterArithExpr(Vb6Parser.ArithExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#arithExpr}.
	 * @param ctx the parse tree
	 */
	void exitArithExpr(Vb6Parser.ArithExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(Vb6Parser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(Vb6Parser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#modOper}.
	 * @param ctx the parse tree
	 */
	void enterModOper(Vb6Parser.ModOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#modOper}.
	 * @param ctx the parse tree
	 */
	void exitModOper(Vb6Parser.ModOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#memberAccessOper}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccessOper(Vb6Parser.MemberAccessOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#memberAccessOper}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccessOper(Vb6Parser.MemberAccessOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#concatOper}.
	 * @param ctx the parse tree
	 */
	void enterConcatOper(Vb6Parser.ConcatOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#concatOper}.
	 * @param ctx the parse tree
	 */
	void exitConcatOper(Vb6Parser.ConcatOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#powOper}.
	 * @param ctx the parse tree
	 */
	void enterPowOper(Vb6Parser.PowOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#powOper}.
	 * @param ctx the parse tree
	 */
	void exitPowOper(Vb6Parser.PowOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#multOper}.
	 * @param ctx the parse tree
	 */
	void enterMultOper(Vb6Parser.MultOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#multOper}.
	 * @param ctx the parse tree
	 */
	void exitMultOper(Vb6Parser.MultOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#divOper}.
	 * @param ctx the parse tree
	 */
	void enterDivOper(Vb6Parser.DivOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#divOper}.
	 * @param ctx the parse tree
	 */
	void exitDivOper(Vb6Parser.DivOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#plusOper}.
	 * @param ctx the parse tree
	 */
	void enterPlusOper(Vb6Parser.PlusOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#plusOper}.
	 * @param ctx the parse tree
	 */
	void exitPlusOper(Vb6Parser.PlusOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#minusOper}.
	 * @param ctx the parse tree
	 */
	void enterMinusOper(Vb6Parser.MinusOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#minusOper}.
	 * @param ctx the parse tree
	 */
	void exitMinusOper(Vb6Parser.MinusOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#isOper}.
	 * @param ctx the parse tree
	 */
	void enterIsOper(Vb6Parser.IsOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#isOper}.
	 * @param ctx the parse tree
	 */
	void exitIsOper(Vb6Parser.IsOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#likeOper}.
	 * @param ctx the parse tree
	 */
	void enterLikeOper(Vb6Parser.LikeOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#likeOper}.
	 * @param ctx the parse tree
	 */
	void exitLikeOper(Vb6Parser.LikeOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#geOper}.
	 * @param ctx the parse tree
	 */
	void enterGeOper(Vb6Parser.GeOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#geOper}.
	 * @param ctx the parse tree
	 */
	void exitGeOper(Vb6Parser.GeOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#gtOper}.
	 * @param ctx the parse tree
	 */
	void enterGtOper(Vb6Parser.GtOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#gtOper}.
	 * @param ctx the parse tree
	 */
	void exitGtOper(Vb6Parser.GtOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#leOper}.
	 * @param ctx the parse tree
	 */
	void enterLeOper(Vb6Parser.LeOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#leOper}.
	 * @param ctx the parse tree
	 */
	void exitLeOper(Vb6Parser.LeOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#ltOper}.
	 * @param ctx the parse tree
	 */
	void enterLtOper(Vb6Parser.LtOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#ltOper}.
	 * @param ctx the parse tree
	 */
	void exitLtOper(Vb6Parser.LtOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#neOper}.
	 * @param ctx the parse tree
	 */
	void enterNeOper(Vb6Parser.NeOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#neOper}.
	 * @param ctx the parse tree
	 */
	void exitNeOper(Vb6Parser.NeOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#orOper}.
	 * @param ctx the parse tree
	 */
	void enterOrOper(Vb6Parser.OrOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#orOper}.
	 * @param ctx the parse tree
	 */
	void exitOrOper(Vb6Parser.OrOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#andOper}.
	 * @param ctx the parse tree
	 */
	void enterAndOper(Vb6Parser.AndOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#andOper}.
	 * @param ctx the parse tree
	 */
	void exitAndOper(Vb6Parser.AndOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#andAlsoOper}.
	 * @param ctx the parse tree
	 */
	void enterAndAlsoOper(Vb6Parser.AndAlsoOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#andAlsoOper}.
	 * @param ctx the parse tree
	 */
	void exitAndAlsoOper(Vb6Parser.AndAlsoOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#assignOper}.
	 * @param ctx the parse tree
	 */
	void enterAssignOper(Vb6Parser.AssignOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#assignOper}.
	 * @param ctx the parse tree
	 */
	void exitAssignOper(Vb6Parser.AssignOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#newOper}.
	 * @param ctx the parse tree
	 */
	void enterNewOper(Vb6Parser.NewOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#newOper}.
	 * @param ctx the parse tree
	 */
	void exitNewOper(Vb6Parser.NewOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#notOper}.
	 * @param ctx the parse tree
	 */
	void enterNotOper(Vb6Parser.NotOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#notOper}.
	 * @param ctx the parse tree
	 */
	void exitNotOper(Vb6Parser.NotOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#addressOfOper}.
	 * @param ctx the parse tree
	 */
	void enterAddressOfOper(Vb6Parser.AddressOfOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#addressOfOper}.
	 * @param ctx the parse tree
	 */
	void exitAddressOfOper(Vb6Parser.AddressOfOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#typeOfOper}.
	 * @param ctx the parse tree
	 */
	void enterTypeOfOper(Vb6Parser.TypeOfOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#typeOfOper}.
	 * @param ctx the parse tree
	 */
	void exitTypeOfOper(Vb6Parser.TypeOfOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#parameterAssignOper}.
	 * @param ctx the parse tree
	 */
	void enterParameterAssignOper(Vb6Parser.ParameterAssignOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#parameterAssignOper}.
	 * @param ctx the parse tree
	 */
	void exitParameterAssignOper(Vb6Parser.ParameterAssignOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(Vb6Parser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(Vb6Parser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#referenceOper}.
	 * @param ctx the parse tree
	 */
	void enterReferenceOper(Vb6Parser.ReferenceOperContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#referenceOper}.
	 * @param ctx the parse tree
	 */
	void exitReferenceOper(Vb6Parser.ReferenceOperContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#qualifiedParameter}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedParameter(Vb6Parser.QualifiedParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#qualifiedParameter}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedParameter(Vb6Parser.QualifiedParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(Vb6Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(Vb6Parser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(Vb6Parser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(Vb6Parser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(Vb6Parser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(Vb6Parser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#specialIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterSpecialIdentifier(Vb6Parser.SpecialIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#specialIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitSpecialIdentifier(Vb6Parser.SpecialIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#specialName}.
	 * @param ctx the parse tree
	 */
	void enterSpecialName(Vb6Parser.SpecialNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#specialName}.
	 * @param ctx the parse tree
	 */
	void exitSpecialName(Vb6Parser.SpecialNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#realParametersNoParen}.
	 * @param ctx the parse tree
	 */
	void enterRealParametersNoParen(Vb6Parser.RealParametersNoParenContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#realParametersNoParen}.
	 * @param ctx the parse tree
	 */
	void exitRealParametersNoParen(Vb6Parser.RealParametersNoParenContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(Vb6Parser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(Vb6Parser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(Vb6Parser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(Vb6Parser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#parmOption}.
	 * @param ctx the parse tree
	 */
	void enterParmOption(Vb6Parser.ParmOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#parmOption}.
	 * @param ctx the parse tree
	 */
	void exitParmOption(Vb6Parser.ParmOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#paramDefaultValue}.
	 * @param ctx the parse tree
	 */
	void enterParamDefaultValue(Vb6Parser.ParamDefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#paramDefaultValue}.
	 * @param ctx the parse tree
	 */
	void exitParamDefaultValue(Vb6Parser.ParamDefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link Vb6Parser#ambiguousKeyword}.
	 * @param ctx the parse tree
	 */
	void enterAmbiguousKeyword(Vb6Parser.AmbiguousKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link Vb6Parser#ambiguousKeyword}.
	 * @param ctx the parse tree
	 */
	void exitAmbiguousKeyword(Vb6Parser.AmbiguousKeywordContext ctx);
}