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
/*
 * This jADT file is an example AST for a toy language.
 * It is marked up with START SNIPPET and END SNIPPET boundaries 
 * to support /jADT/src/site/apt/*.apt
 */
package com.pogofish.jadt.samples.whathow.data;

/*
This file was generated based on /Users/jiry/workspace/JADT/jADT-samples/src/main/jadt/WhatHowSamples.jadt using jADT version 0.3.0-SNAPSHOT http://jamesiry.github.com/jADT/ . Please do not modify directly.

The source was parsed as: 

OptionalInt =
    Some(int value)
  | None
*/
public abstract class OptionalInt {

   private OptionalInt() {
   }

   public static final  OptionalInt _Some(int value) { return new Some(value); }
   private static final OptionalInt _None = new None();
   public static final  OptionalInt _None() { return _None; }

   public static interface MatchBlock<ResultType> {
      ResultType _case(Some x);
      ResultType _case(None x);
   }

   public static abstract class MatchBlockWithDefault<ResultType> implements MatchBlock<ResultType> {
      @Override
      public ResultType _case(Some x) { return _default(x); }

      @Override
      public ResultType _case(None x) { return _default(x); }

      protected abstract ResultType _default(OptionalInt x);
   }

   public static interface SwitchBlock {
      void _case(Some x);
      void _case(None x);
   }

   public static abstract class SwitchBlockWithDefault implements SwitchBlock {
      @Override
      public void _case(Some x) { _default(x); }

      @Override
      public void _case(None x) { _default(x); }

      protected abstract void _default(OptionalInt x);
   }

   public static final class Some extends OptionalInt {
      public int value;

      public Some(int value) {
         this.value = value;
      }

      @Override
      public <ResultType> ResultType match(MatchBlock<ResultType> matchBlock) { return matchBlock._case(this); }

      @Override
      public void _switch(SwitchBlock switchBlock) { switchBlock._case(this); }

      @Override
      public int hashCode() {
          final int prime = 31;
          int result = 1;
          result = prime * result + value;
          return result;
      }

      @Override
      public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null) return false;
         if (getClass() != obj.getClass()) return false;
         Some other = (Some)obj;
         if (value != other.value) return false;
         return true;
      }

      @Override
      public String toString() {
         return "Some(value = " + value + ")";
      }

   }

   public static final class None extends OptionalInt {

      public None() {
      }

      @Override
      public <ResultType> ResultType match(MatchBlock<ResultType> matchBlock) { return matchBlock._case(this); }

      @Override
      public void _switch(SwitchBlock switchBlock) { switchBlock._case(this); }

      @Override
      public int hashCode() {
          return 0;
      }

      @Override
      public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null) return false;
         if (getClass() != obj.getClass()) return false;
         return true;
      }

      @Override
      public String toString() {
         return "None";
      }

   }

   public abstract <ResultType> ResultType match(MatchBlock<ResultType> matchBlock);

   public abstract void _switch(SwitchBlock switchBlock);

}