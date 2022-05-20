/*
 *
 *  * Copyright (c) 2020 Sambit Paul
 *  *
 *  * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *  *
 *  * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *  *
 *  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.github.psambit9791.jdsp.transform;

public class InverseDiscreteCosine implements _InverseCosine{

    private double[] signal;
    private double[] output = null;
    private int type;

    private DiscreteCosine.Normalization norm;

    private int inferType(int t) {
        int inf = 0;
        if (t == 1 || t == 4) {
            inf = t;
        }
        else if (t == 2) {
            inf = 3;
        }
        else if (t == 3) {
            inf = 2;
        }
        return inf;
    }

    public InverseDiscreteCosine(double[] s, int type, DiscreteCosine.Normalization norm) throws IllegalArgumentException {
        if ((type <= 0) || (type > 4)) {
            throw new IllegalArgumentException("Type must be between 1 and 4");
        }
        this.signal = s;
        this.type = this.inferType(type);
        this.norm = norm;

    }

    public InverseDiscreteCosine(double[] s, DiscreteCosine.Normalization norm) throws IllegalArgumentException {
        this.signal = s;
        this.type = this.inferType(2);
        this.norm = norm;
    }

    public InverseDiscreteCosine(double[] s, int type) throws IllegalArgumentException {
        if ((type <= 0) || (type > 4)) {
            throw new IllegalArgumentException("Type must be between 1 and 4");
        }
        this.signal = s;
        this.type = this.inferType(type);
        this.norm = DiscreteCosine.Normalization.STANDARD;
    }

    public InverseDiscreteCosine(double[] s) {
        this.signal = s;
        this.type = this.inferType(2);
        this.norm = DiscreteCosine.Normalization.STANDARD;
    }

    public void transform() {
        DiscreteCosine dct = new DiscreteCosine(this.signal, this.type, this.norm);
        dct.transform();
        this.output = dct.getMagnitude();
    }

    public double[] getMagnitude() throws ExceptionInInitializerError {
        if (this.output == null) {
            throw new ExceptionInInitializerError("Execute transform() function before returning result");
        }
        return this.output;
    }

    public int getSignalLength() {
        return this.signal.length;
    }
}
