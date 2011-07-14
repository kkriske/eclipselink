package eclipselink.utils.sigcompare;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassSignature {

    private String name;

    private String[] interfaces;

    private String parentName;

    private ClassSignature parent;

    private Map<String, List<String>> methods;

    private Map<String, String> fields;

    public ClassSignature(String name, String parentName, String[] interfaces) {
        this.name = name;
        this.interfaces = interfaces;
        this.parentName = parentName;
        this.methods = new HashMap<String, List<String>>();
        this.fields = new HashMap<String, String>();
    }

    public String getName() {
        return name;
    }

    public String[] getInterfaces() {
        return interfaces;
    }

    public void initialzeParent(Map<String, ClassSignature> sigs) {
        this.parent = sigs.get(this.parentName);
    }

    public void addMethod(String name, String desc) {
        List<String> methodDescs = this.methods.get(name);

        if (methodDescs == null) {
            methodDescs = new ArrayList<String>();
            this.methods.put(name, methodDescs);
        }
        methodDescs.add(desc);
    }

    public void addField(String name, String desc) {
        if (this.fields.containsKey(name)) {
            throw new RuntimeException("Duplicate field: " + name + " on class: " + getName());
        }
        this.fields.put(name, desc);
    }

    public boolean containsField(String fieldName, String desc) {
        String fieldDesc = this.fields.get(fieldName);
        return desc.equals(fieldDesc);
    }

    public boolean containsMethod(String methodName, String desc) {
        List<String> methodDescs = this.methods.get(methodName);

        if (methodDescs != null) {
            if (methodDescs.contains(desc)) {
                return true;
            }
        }

        if (this.parent != null) {
            return this.parent.containsMethod(methodName, desc);
        }
        return false;
    }

    public void compare(ClassSignature targetSig, Writer writer) throws IOException {
        boolean printClass = false;

        for (Map.Entry<String, String> fieldEntry : this.fields.entrySet()) {
            if (!targetSig.containsField(fieldEntry.getKey(), fieldEntry.getValue())) {
                if (!printClass) {
                    writer.write(getName() + "\n");
                    printClass = true;
                }
                writer.write("\tCould not find field: " + fieldEntry.getKey() + " :: " + fieldEntry.getValue() + "\n");
            }
        }

        for (Map.Entry<String, List<String>> methodEntry : this.methods.entrySet()) {
            for (String desc : methodEntry.getValue()) {
                if (!targetSig.containsMethod(methodEntry.getKey(), desc)) {
                    if (!printClass) {
                        writer.write(getName() + "\n");
                        printClass = true;
                    }
                    writer.write("\tCould not find method: " + methodEntry.getKey() + " :: " + desc + "\n");
                }
            }
        }
    }

}
