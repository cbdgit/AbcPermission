package personal.nfl.permission.util;

/**
 * Created by fuli.niu on 2017/12/18.
 */

public class CodeCreator {


    public static String brewCode(String packageName, String enclosingName, String[] permissions, String classPostfix, String methodName, String returnType) {

        StringBuilder builder = new StringBuilder();
        builder.append("package " + packageName + ";\n\n");
        builder.append("import android.app.FragmentManager;\n");
        builder.append("import android.app.FragmentTransaction;\n");
        builder.append("import android.graphics.Color;\n");
        builder.append("import android.os.Build;\n");
        builder.append("import android.support.annotation.RequiresApi;\n");
        builder.append("import android.util.Log;\n");
        builder.append("import android.view.View;\n");
        builder.append("import android.view.ViewGroup;\n");
        builder.append("import android.widget.FrameLayout;\n");
        builder.append("import org.aspectj.lang.JoinPoint;\n");
        builder.append("import org.aspectj.lang.ProceedingJoinPoint;\n");
        builder.append("import org.aspectj.lang.annotation.After;\n");
        builder.append("import org.aspectj.lang.annotation.Around;\n");
        builder.append("import org.aspectj.lang.annotation.Aspect;\n");
        builder.append("import org.aspectj.lang.annotation.Before;\n");
        builder.append("import org.aspectj.lang.annotation.Pointcut;\n");
        builder.append("import personal.nfl.permission.support.constant.ApplicationConstant;\n");
        builder.append("import personal.nfl.permission.support.util.AbcPermission;\n");
        builder.append("import personal.nfl.permission.support.view.Permission23Fragment;\n");
        builder.append("import personal.nfl.permission.support.R;\n");
        builder.append("//Auto generated by apt,do not modify!!\n\n");
        builder.append("@Aspect\n");
        builder.append("public class AutoCreate");
        builder.append(classPostfix);
        builder.append(" { \n\n");

        builder.append("private String[] permissions = {");
        for (int i = 0; i < permissions.length; i++) {
            builder.append("\"");
            builder.append(permissions[i]);
            builder.append("\"");
            if (i < permissions.length - 1) {
                builder.append(',');
            }
        }
        builder.append("};\n");
        builder.append("private final String METHOD_CALL = \"call(* ");
        builder.append(enclosingName);
        builder.append(".");
        builder.append(methodName);
        builder.append("(..))\";\n");

        builder.append("private final String METHOD_EXE = \"execution(* ");
        builder.append(enclosingName);
        builder.append(".");
        builder.append(methodName);
        builder.append("(..))\";\n");

        builder.append("private ProceedingJoinPoint proceedingJoinPoint;\n");

        builder.append("@Pointcut(METHOD_CALL)\n");
        builder.append("public void methodCall() {}\n");

        builder.append("@Pointcut(METHOD_EXE)\n");
        builder.append("public void methodExe() {}\n");

        // create method beforeCall
        builder.append("@Before(\"methodCall()\")\n");
        builder.append("public void beforeCall(JoinPoint joinPoint) {\n");
        builder.append("Log.i(\"NFL\", \"beforeCall Permission23Fragment\");\n");
        builder.append("if (android.os.Build.VERSION.SDK_INT >= 14) {\n");
        builder.append("ViewGroup viewGroup = ApplicationConstant.nowActivity.getWindow().getDecorView().findViewById(android.R.id.content);\n");
        builder.append("FrameLayout frameLayout = ApplicationConstant.nowActivity.findViewById(R.id.permission23);\n");
        builder.append(" if (null == frameLayout) {\n");
        builder.append("frameLayout = new FrameLayout(ApplicationConstant.nowActivity);\n");
        builder.append("frameLayout.setVisibility(View.GONE);\n");
        builder.append("frameLayout.setBackgroundColor(Color.GREEN);\n");
        builder.append("frameLayout.setId(R.id.permission23);\n");
        builder.append("viewGroup.addView(frameLayout);\n");
        builder.append("}\n");

        builder.append("final FragmentManager fragmentManager = ApplicationConstant.nowActivity.getFragmentManager();\n");
        builder.append("FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();\n");
        builder.append("final Permission23Fragment permission23Fragment = new Permission23Fragment();\n");
        builder.append("permission23Fragment.setPermissionsHandler(permissionsHandler);\n");
        builder.append("fragmentTransaction.add(R.id.permission23, permission23Fragment);\n");
        builder.append("fragmentTransaction.commit();\n");
        builder.append("frameLayout.post(new Runnable() {\n");
        builder.append("@RequiresApi(api = Build.VERSION_CODES.M)\n");
        builder.append("@Override\n");
        builder.append("public void run() {\n");
        builder.append(" permission23Fragment.requestPermissions(permissions);\n");
        builder.append("}\n");
        builder.append("});\n");
        builder.append("}\n");
        builder.append("}\n");
        // create method aroundExe
        builder.append("@Around(\"methodExe()\")\n");
        builder.append("public ");
        if ("void".equals(returnType)) {
            builder.append("Object");
        } else {
            builder.append(returnType);
        }
        builder.append(" aroundExe(ProceedingJoinPoint proceedingJoinPoint){\n");
        builder.append(" Log.i(\"NFL\", \"in Permission23Fragment exe\");\n");
        ///////////////////////////////////////////////////////////////////////////////////////////
        builder.append("if(android.os.Build.VERSION.SDK_INT < 14){\n");
        builder.append("try {\n");
        builder.append("return " + ("void".equals(returnType) ? "" : "(" + returnType + ") ") + "proceedingJoinPoint.proceed() ;\n");
        builder.append("} catch (Throwable throwable) {\n");
        builder.append("AbcPermission.permissionListener.exeException(throwable);\n");
        builder.append("return null ;\n");
        builder.append("}\n");
        builder.append("}\n");
        builder.append("else{\n");
        builder.append("this.proceedingJoinPoint = proceedingJoinPoint;\n");
        builder.append("}\n");

        builder.append("return null ;\n");
        builder.append("}\n");
        ///////////////////////////////////////////////////////////////////////////////////////////
        // create method afterCall
        builder.append("@After(\"methodCall()\")\n");
        builder.append("public void afterCall(JoinPoint joinPoint) {\n");
        builder.append(" Log.i(\"NFL\", \"after Permission23Fragment exe\");}\n");
        // create PermissionsHandler
        builder.append("private Permission23Fragment.PermissionsHandler permissionsHandler = new Permission23Fragment.PermissionsHandler() {\n");
        builder.append("@Override\n");
        builder.append("public void success() {\n");
        builder.append("try {\n");
        builder.append("proceedingJoinPoint.proceed();\n");
        builder.append("} catch (Throwable throwable) {\n");
        builder.append("AbcPermission.permissionListener.exeException(throwable);\n");
        builder.append("}\n");
        builder.append("}\n");
        builder.append("};\n");
        // create file finish
        builder.append("}\n");
        return builder.toString();
    }


    public static String brewCodeNoCallback(String packageName, String enclosingName, String[] permissions, String classPostfix, String methodName, String returnType) {
        StringBuilder builder = new StringBuilder();
        builder.append("package " + packageName + ";\n\n");
        builder.append("import android.Manifest;\n");
        builder.append("import android.app.Activity;\n");
        builder.append("import android.content.Context;\n");
        builder.append("import android.content.Intent;\n");
        builder.append("import android.content.pm.PackageManager;\n");
        builder.append("import android.net.Uri ;\n");
        builder.append("import android.support.v4.content.ContextCompat;\n");
        builder.append("import android.support.v4.app.ActivityCompat;\n");
        builder.append("import android.util.Log;\n");
        builder.append("import org.aspectj.lang.JoinPoint;\n");
        builder.append("import org.aspectj.lang.ProceedingJoinPoint;\n");

        builder.append("import personal.nfl.permission.support.constant.ApplicationConstant;\n");
        builder.append("import personal.nfl.permission.support.util.AbcPermission;\n");
        builder.append("import personal.nfl.permission.support.util.SharePreferenceTool;\n");
        builder.append("import org.aspectj.lang.annotation.After;\n");
        builder.append("import org.aspectj.lang.annotation.Around;\n");
        builder.append("import org.aspectj.lang.annotation.Aspect;\n");
        builder.append("import org.aspectj.lang.annotation.Before;\n");
        builder.append("import org.aspectj.lang.annotation.Pointcut;\n");
        builder.append("import java.util.ArrayList;\n");
        builder.append("import java.util.List;\n");
        builder.append("//Auto generated by apt,do not modify!!\n\n");
        builder.append("@Aspect\n");
        builder.append("public class AutoCreate");
        builder.append(classPostfix);
        builder.append(" { \n\n");

        builder.append("private String[] permissions = {");
        for (int i = 0; i < permissions.length; i++) {
            builder.append("\"");
            builder.append(permissions[i]);
            builder.append("\"");
            if (i < permissions.length - 1) {
                builder.append(',');
            }
        }
        builder.append("};\n");
        builder.append("private final String METHOD_CALL = \"call(* ");
        builder.append(enclosingName);
        builder.append(".");
        builder.append(methodName);
        builder.append("(..))\";\n");

        builder.append("private final String METHOD_EXE = \"execution(* ");
        builder.append(enclosingName);
        builder.append(".");
        builder.append(methodName);
        builder.append("(..))\";\n");

        builder.append("@Pointcut(METHOD_CALL)\n");
        builder.append("public void methodCall() {}\n");

        builder.append("@Pointcut(METHOD_EXE)\n");
        builder.append("public void methodExe() {}\n");
        // create method beforeCall
        builder.append("@Before(\"methodCall()\")\n");
        builder.append("public void beforeCall(JoinPoint joinPoint) {\n");
        builder.append(" Log.i(\"NFL\", \"before GetPermissions exe\");}\n");
        // create method aroundExe
        builder.append("@Around(\"methodExe()\")\n");
        builder.append("public ");
        if ("void".equals(returnType)) {
            builder.append("Object");
        } else {
            builder.append(returnType);
        }
        builder.append(" aroundExe(ProceedingJoinPoint proceedingJoinPoint){\n");
        builder.append(" Log.i(\"NFL\", \"in GetPermissions exe\");\n");
        ///////////////////////////////////////////////////////////////////////////////////////////
        builder.append("if(android.os.Build.VERSION.SDK_INT < 14){\n");
        builder.append("try {\n");
        builder.append("return " + ("void".equals(returnType) ? "" : "(" + returnType + ") ") + "proceedingJoinPoint.proceed() ;\n");
        builder.append("} catch (Throwable throwable) {\n");
        builder.append("AbcPermission.permissionListener.exeException(throwable);\n");
        builder.append("return null ;\n");
        builder.append("}\n");
        builder.append("}\n");
        builder.append("List<String> permissionList = new ArrayList<>();\n");
        builder.append("for (String permission : permissions) {\n");
        builder.append("if (ContextCompat.checkSelfPermission(ApplicationConstant.nowActivity , permission) != PackageManager.PERMISSION_GRANTED) {\n");
        builder.append("permissionList.add(permission);}}\n");
        builder.append("if (permissionList.size() == 0) {\n");
        // exe annotation method
        if ("void".equals(returnType)) {
            builder.append("try {\n");
            builder.append("proceedingJoinPoint.proceed();\n");
            builder.append("} catch (Throwable throwable) {\n");
            builder.append("AbcPermission.permissionListener.exeException(throwable);\n");
            builder.append("}\n");
            builder.append("return null ;\n");
        } else {
            builder.append("try {\n");
            builder.append(returnType);
            builder.append(" result = (" + returnType +
                    ") proceedingJoinPoint.proceed();\n");
            builder.append("return result;\n");
            builder.append("} catch (Throwable throwable) {\n");
            builder.append("AbcPermission.permissionListener.exeException(throwable);\n");
            builder.append("return null ;\n");
            builder.append("}\n");
        }
        // exe annotation method
        builder.append("} else {\n");
        builder.append("String[] permissionListTemp = new String[permissionList.size()] ;\n");
        builder.append("for(int i = 0 ; i < permissionList.size() ; i++){\n");
        builder.append("permissionListTemp[i] = permissionList.get(i) ;\n");
        builder.append("}\n");

        builder.append("for (int i = 0; i < permissionList.size(); i++) {\n");
        builder.append("if (ContextCompat.checkSelfPermission(ApplicationConstant.nowActivity , permissionList.get(i)) != PackageManager.PERMISSION_GRANTED) {\n");
        builder.append(" Log.i(\"NFL\", \"PERMISSION_DENY\");\n");
        builder.append("if (ActivityCompat.shouldShowRequestPermissionRationale(ApplicationConstant.nowActivity , permissionList.get(i))) {\n");
        builder.append(" Log.i(\"NFL\", \"shouldShowRequestPermissionRationale\");\n");
        builder.append("ActivityCompat.requestPermissions(ApplicationConstant.nowActivity , permissionListTemp , 0);\n");
        builder.append("break;\n");
        builder.append("} else {\n");
        builder.append("if (SharePreferenceTool.readObject(permissionList.get(i)) != null) {\n");
        builder.append(" Log.i(\"NFL\", \"SharePreferenceTool not null \");\n");
        builder.append("if (!ActivityCompat.shouldShowRequestPermissionRationale(ApplicationConstant.nowActivity , permissionList.get(i))) {\n");
        builder.append(" Log.i(\"NFL\", \"!shouldShowRequestPermissionRationale not null \");\n");
        builder.append("AbcPermission.permissionListener.cannotRequestAgain(ApplicationConstant.nowActivity , permissionListTemp);");
        builder.append("break;\n");
        builder.append("}\n");
        builder.append("} else\n");
        builder.append("{\n");
        builder.append("if (permissionList.size() - 1 == i) {\n");
        builder.append("ActivityCompat.requestPermissions(ApplicationConstant.nowActivity , permissionListTemp , 0);\n");
        builder.append("}\n");
        builder.append("SharePreferenceTool.saveObject(\"rejected\", permissionList.get(i));\n");
        builder.append("}\n");
        builder.append("}\n");
        builder.append("}\n");
        builder.append("}\n");
        builder.append("}\n");
        builder.append("return null ;\n");
        builder.append("}\n");
        ///////////////////////////////////////////////////////////////////////////////////////////
        // create method afterCall
        builder.append("@After(\"methodCall()\")\n");
        builder.append("public void afterCall(JoinPoint joinPoint) {\n");
        builder.append(" Log.i(\"NFL\", \"after GetPermissions exe\");}\n");
        // create file finish
        builder.append("}");
        return builder.toString();
    }
}
