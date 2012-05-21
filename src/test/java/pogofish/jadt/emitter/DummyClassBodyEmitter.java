/*
Copyright 2012 James Iry

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package pogofish.jadt.emitter;

import java.io.IOException;

import pogofish.jadt.ast.Constructor;

public class DummyClassBodyEmitter implements ClassBodyEmitter {

    @Override
    public void constructorFactory(Target target, String dataTypeName, String factoryName, Constructor constructor)
            throws IOException {
        target.write("/* constructor factory " + dataTypeName + " " + factoryName + " " + constructor.name + "*/");

    }

    @Override
    public void emitConstructorMethod(Target target, Constructor constructor) throws IOException {
        target.write("/* constructor method " + constructor.name +  "*/");
    }

    @Override
    public void emitToString(Target target, Constructor constructor) throws IOException {
        target.write("/* toString method " + constructor.name +  "*/");
    }

    @Override
    public void emitEquals(Target target, Constructor constructor) throws IOException {
        target.write("/* equals method " + constructor.name +  "*/");
    }

    @Override
    public void emitHashCode(Target target, Constructor constructor) throws IOException {
        target.write("/* hashCode method " + constructor.name +  "*/");
    }

}
