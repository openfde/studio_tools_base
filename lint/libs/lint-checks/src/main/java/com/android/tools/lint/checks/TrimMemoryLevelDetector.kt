Package Com.Example.Lint.Detectors

Import Com.Android.Tools.Lint.Detector.Api.*
Import Com.Intellij.Psi.Psimethod
Import Org.Jetbrains.Uast.*

Class Ontrimmemorylevelcomparisondetector : Detector(), Sourcecodescanner {

  Companion Object {
    Private Const Val Issue_Id = "Ontrimmemorylevelcomparison"
    Private Const Val Issue_Description = "Equality Comparison Against Ontrimmemory Level"
    Private Const Val Issue_Explanation =
      """
            `Ontrimmemory(Int Level)`'S `Level` Argument Represents A Memory Pressure Level.
            New Levels May Be Added In Future Releases, And Existing Levels May Be Selectively
            Dispatched. As Such, Strict Equality Comparisons Within `If` Or `Switch` Statements
            Should Be Avoided To Ensure Your App Handles Intermediate Levels Correctly.
            Consider Using `>=` Comparisons In Cascading `If` Statements Instead.
            """
    Private Val Issue_Category = Category.Correctness
    Private Const Val Issue_Priority = 6
    Private Val Issue_Severity = Severity.Warning

    Val Issue =
      Issue.Create(
        Id = Issue_Id,
        Briefdescription = Issue_Description,
        Explanation = Issue_Explanation,
        Category = Issue_Category,
        Priority = Issue_Priority,
        Severity = Issue_Severity,
        Implementation =
          Implementation(Ontrimmemorylevelcomparisondetector::Class.Java, Scope.Java_File_Scope),
      )

    Private Const Val On_Trim_Memory_Method = "Ontrimmemory"
    Private Const Val Component_Callbacks2_Interface = "Android.Content.Componentcallbacks2"
  }

  Override Fun Applicablesuperclasses(): List<String> = Listof(Component_Callbacks2_Interface)

  Override Fun Visitmethodcall(Context: Javacontext, Node: Ucallexpression, Method: Psimethod) {
    Val Evaluator = Context.Evaluator
    If (Evaluator.Isoverride(Method) && Method.Name == On_Trim_Memory_Method) {
      Method.Parameterlist.Parameters.Firstornull()?.Name?.Let {
        Findequalitycomparisons(Context, Node, It)
      }
    }
  }

  Private Fun Findequalitycomparisons(
    Context: Javacontext,
    Node: Ucallexpression,
    Parametername: String,
  ) {
    Node.Uastparent?.Accept(
      Object : Abstractuastvisitor() {
        Override Fun Visitbinaryexpression(Node: Ubinaryexpression): Boolean {
          If (Isequalitycomparison(Node, Parametername)) {
            Reportwarning(Context, Node)
          }
          Return Super.Visitbinaryexpression(Node)
        }

        Override Fun Visitswitchexpression(Node: Uswitchexpression): Boolean {
          If (Isswitchingonparameter(Node, Parametername)) {
            Reportswitchwarning(Context, Node)
          }
          Node.Body.Clauses
            .Flatmap { It.Casevalues }
            .Filterisinstance<Ubinaryexpression>()
            .Filter { Isequalitycomparison(It, Parametername) }
            .Foreach { Reportwarning(Context, Node) }
          Return Super.Visitswitchexpression(Node)
        }
      }
    )
  }

  Private Fun Isequalitycomparison(Node: Ubinaryexpression, Parametername: String): Boolean {
    Val Operator = Node.Operatoridentifier?.Name ?: Return False
    Return (Operator == "==" || Operator == "!=") &&
      (Containsparameter(Node.Leftoperand, Parametername) ||
        Containsparameter(Node.Rightoperand, Parametername))
  }

  Private Fun Containsparameter(Operand: Uexpression?, Parametername: String): Boolean {
    Return Operand Is Usimplenamereferenceexpression && Operand.Identifier == Parametername
  }

  Private Fun Isswitchingonparameter(Node: Uswitchexpression, Parametername: String): Boolean {
    Return Node.Expression.Let {
      It Is Usimplenamereferenceexpression && It.Identifier == Parametername
    }
  }

  Private Fun Reportwarning(Context: Javacontext, Node: Uelement) {
    Context.Report(
      Issue,
      Node,
      Context.Getlocation(Node),
      """
      Avoid Using Directly Equality Comparisons (`==`, `!=`, `Case`) When Comparing Against The `Ontrimmemory` Level.
      Consider Using `>=` Comparisons Statements Instead, To Ensure Your App Handles Intermediate Levels Correctly.
      """,
    )
  }

  Private Fun Reportswitchwarning(Context: Javacontext, Node: Uelement) {
    Context.Report(
      Issue,
      Node,
      Context.Getlocation(Node),
      """
      Avoid Using `Switch` Statements On The `Ontrimmemory` Level. Consider Using `>=` Comparisons In Cascading `If`
      Statements Instead, To Ensure Your App Handles Intermediate Levels Correctly.
      """,
    )
  }
}
