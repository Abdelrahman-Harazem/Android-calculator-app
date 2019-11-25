package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView resultTextView ;
    double memoryValue = 0.0;
    int  dotCount = 0;
    boolean operator = false ;
    double textViewValue ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = (TextView) findViewById(R.id.resultTextView);
        resultTextView.setText("");
        Button oneButton =(Button) findViewById(R.id.oneButton) ;
        Button twoButton =(Button) findViewById(R.id.twoButton) ;
        Button threeButton =(Button) findViewById(R.id.threeButton) ;
        Button fourButton =(Button) findViewById(R.id.fourButton) ;
        Button fiveButton =(Button) findViewById(R.id.fiveButton) ;
        Button sixButton =(Button) findViewById(R.id.sixButton) ;
        Button sevenButton =(Button) findViewById(R.id.sevenButton) ;
        Button eightButton =(Button) findViewById(R.id.eightButton) ;
        Button nineButton =(Button) findViewById(R.id.nineButton) ;
        Button zeroButton =(Button) findViewById(R.id.zeroButton) ;
        Button plusButton =(Button) findViewById(R.id.plusButton) ;
        Button minusButton =(Button) findViewById(R.id.minusButton) ;
        Button multiplyButton =(Button) findViewById(R.id.multiplyButton) ;
        Button divisionButton =(Button) findViewById(R.id.divisionButton) ;
        Button rightParantheButton =(Button) findViewById(R.id.rightParenthesButton) ;
        Button leftParantheButton =(Button) findViewById(R.id.leftParenthesButton) ;
        Button dotButton =(Button) findViewById(R.id.dotButton) ;
        Button deleteButton = (Button) findViewById(R.id.delButton) ;
        Button clearButton = (Button) findViewById(R.id.clrButton) ;
        Button equalButton = (Button) findViewById(R.id.equalButton) ;
        Button memoryButton = (Button) findViewById(R.id.memoryButton) ;
        Button memoryAddButton = (Button) findViewById(R.id.memoryAddButton) ;
        Button memoryMinusButton = (Button) findViewById(R.id.memoryMinusButton) ;
        Button negativeSignButton = (Button) findViewById(R.id.negativeSignButton) ;



        negativeSignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate calc = new Calculate();
                calc.setExp(resultTextView.getText().toString());
                if(resultTextView.getText().length()>0){
                    try{
                        double resultDouble =Double.parseDouble(calc.getResult(calc.getExp())) *-1 ;
                        String resultString = Double.toString(resultDouble);
                        resultTextView.setText(resultString);
                    }
                    catch (Exception e){
                        resultTextView.setText("ERROR");
                    }

                }


            }
        });

        memoryAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resultTextView.getText().toString().length()>0) {
                    try {
                        memoryValue += Double.parseDouble(resultTextView.getText().toString());
                        Toast.makeText(getApplicationContext(), "memory value now = "+Double.toString(memoryValue), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        memoryMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resultTextView.getText().toString().length()>0) {
                    try {
                        memoryValue -= Double.parseDouble(resultTextView.getText().toString());
                       Toast.makeText(getApplicationContext(), "memory value now = "+Double.toString(memoryValue), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        memoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String string = resultTextView.getText().toString();
                    if(string.length()>0){
                        textViewValue = Double.parseDouble(resultTextView.getText().toString());
                    }
                    if(resultTextView.getText().toString().length()==0 ||resultTextView.getText().toString()=="" || resultTextView.getText().toString()==null){
                        resultTextView.setText(Double.toString(memoryValue));
                    }
                    else if (textViewValue != memoryValue){
                        Toast.makeText(getApplicationContext(),"Please Clear the Text View first to view memory Value ",Toast.LENGTH_LONG).show();
                    }

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"There is no value to store it in the memory ",Toast.LENGTH_SHORT).show();
                }

            }
        });


        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate calc = new Calculate();
                calc.setExp(resultTextView.getText().toString());
                // Toast.makeText(getApplicationContext(),calc.getExp(),Toast.LENGTH_SHORT).show();
                String r = calc.getResult(calc.getExp())+"";
                // Toast.makeText(getApplicationContext(),"hii"+calc.getResult(calc.exp),Toast.LENGTH_SHORT).show();
                resultTextView.setText(r);
            }
        });


        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTextView.setText("");
                dotCount = 0;
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= (String) resultTextView.getText().toString();
                String r="";
                try{
                    double n = Double.parseDouble(s);
                    if(!s.isEmpty()){
                        String d = s.substring(s.length()-1);
                        if(d.equals(".")){
                            dotCount--;
                        }
                        r=s.substring(0,s.length()-1);
                    }

                    resultTextView.setText(r);
                }catch (NumberFormatException e){
                    resultTextView.setText("");
                }

            }
        });

        zeroButton.setOnClickListener(this);
        oneButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);
        fourButton.setOnClickListener(this);
        fiveButton.setOnClickListener(this);
        sixButton.setOnClickListener(this);
        sevenButton.setOnClickListener(this);
        eightButton.setOnClickListener(this);
        nineButton.setOnClickListener(this);
        plusButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        divisionButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);
        rightParantheButton.setOnClickListener(this);
        leftParantheButton.setOnClickListener(this);
        dotButton.setOnClickListener(this);
        //memoryButton.setOnClickListener(this);

    }

    public boolean isoperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onClick(View v) {
        Button button = (Button)v;


        if(resultTextView.getText().toString().length()==18){
            Toast.makeText(getApplicationContext(),"Text Field Max length Limit  exceeded",Toast.LENGTH_SHORT).show();
        }
        else if(resultTextView.getText().toString().length()==0 ||resultTextView.getText().toString()=="" || resultTextView.getText().toString()==null) {
            operator = true ;
            if (!isoperator(button.getText().toString())) {
                if(button.getId()==R.id.dotButton){
                    resultTextView.setText("0"+button.getText().toString());
                    dotCount ++;
                }
                else {
                    resultTextView.setText(button.getText().toString());
                }
            }

        }

        else if(isoperator(button.getText().toString()) && !(button.getId()==R.id.rightParenthesButton) && !(button.getId()==R.id.leftParenthesButton)){
            if(! operator){
                boolean freeze = true ;
            }
            else{
                resultTextView.append(button.getText().toString());
                operator = false ;
            }
        }
        else {
            operator = true ;

            if(button.getId()==R.id.zeroButton && resultTextView.getText().toString().equals("0")){
                boolean freeze = true ;
                //Toast.makeText(getApplicationContext(),"i reach here ",Toast.LENGTH_SHORT).show();
            }
            else if(button.getId()==R.id.dotButton ){
                if(dotCount >=1){

                }
                else{
                    resultTextView.append(button.getText().toString());
                    dotCount++;
                    operator = true ;
                }
                // resultTextView.append(button.getText().toString());
                // dotCount ++;

            }
            else {
                //  Toast.makeText(getApplicationContext(),"text : "+resultTextView.getText().toString()+" my digit is"+button.getText().toString(),Toast.LENGTH_SHORT).show();
                resultTextView.append(button.getText().toString());

                operator = true ;

            }
        }


    }

    public class Calculate {
        String exp;
        Stack operand;
        Stack operator;
        public Calculate(){

            operand=new Stack();
            operator=new Stack();
        }
        public void setExp(String exp){
            this.exp = exp;
        }
        public String getExp(){
            return exp;
        }
        public String getResult(String exp){
            // Toast.makeText(getApplicationContext(),exp,Toast.LENGTH_SHORT).show();
            String r = infix(exp);
            try{
                return r;
            }
            catch(Exception e){
                return "Error";
            }
        }
        private String[] splitExp(String s){
            String[] pieces = s.split("(?<=\\+|-|\\*|/|\\(|\\))|(?=\\+|-|\\*|/|\\(|\\))");

            for(int j=0;j<pieces.length;j++){
                //Toast.makeText(getApplicationContext(), pieces[j], Toast.LENGTH_SHORT).show();
                //System.out.println(pieces[j]);
                //Log.i("element is ",pieces[j]);
                if(pieces[j].indexOf("..")!=-1){
                    return new String[]{"ERROR"};
                }
                if(pieces[j]=="."){
                    return new String[]{"ERROR"};
                }
            }
            for(int i=0;i<pieces.length;i++) {
                // Log.i("element", pieces[i]);
                //if(!isSymbol(pieces[i]) && !isNumber(pieces[i]))
                //  continue;

                if(!isSymbol(pieces[i]))
                    try {
                        double n = Double.parseDouble(pieces[i]);
                        //Toast.makeText(getApplicationContext(),Double.toString(n),Toast.LENGTH_SHORT).show();
                    } catch (NumberFormatException e) {
                        //Toast.makeText(getApplicationContext(), pieces[0], Toast.LENGTH_SHORT).show();
                        //return new String[]{"ERROR"};
                        pieces[i]="0";
                        //Toast.makeText(getApplicationContext(), pieces[0], Toast.LENGTH_SHORT).show();
                    }
              //  Toast.makeText(getApplicationContext(), pieces[i], Toast.LENGTH_SHORT).show();
            }
            // System.out.println(pieces);
            return pieces;
        }
        private boolean isSymbol(String s){
            if(s.equals("(")||s.equals(")")||s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")) {
                return true;
            }
            else {
                return false;
            }
        }

        private boolean isNumber(String s){
            if(s.equals("1")||s.equals("2")||s.equals("3")||s.equals("4")||s.equals("5")||s.equals("6")||s.equals("7")||s.equals("8")||s.equals("9")||s.equals("0")) {
                return true;
            }
            else {
                return false;
            }
        }


        public double add(double a , double b){
            return a+b;
        }
        public double sub(double a , double b){
            return a-b;
        }
        public double mul(double a , double b){
            return a*b;
        }
        public double div(double a , double b){
            if(a>0&&b==0)
                return Double.POSITIVE_INFINITY;
            else if(a<0&&b==0)
                return Double.NEGATIVE_INFINITY;
            else if(a==0&&b==0)
                return Double.NaN;
            return a/b;
        }
        private String infix(String s){
            if(s.isEmpty())
                return "";
            String[] pieces = splitExp(s);
            if(pieces[0].equals("ERROR"))
                return "ERROR ";
            for(int i=0;i<pieces.length;i++){
                if(pieces[i].equals("+")||pieces[i].equals("-")||pieces[i].equals("*")||pieces[i].equals("/")||pieces[i].equals("(")||pieces[i].equals(")")){
                    if(operator.empty()||(String)operator.peek()=="(")
                        operator.push((String)pieces[i]);
                    else if(pieces[i].equals(")")){
                        while(true){
                            if(operator.peek().equals("(")){
                                if(operator.isEmpty())
                                    return "ERROR";
                                operator.pop();
                                break;
                            }
                            if(operand.isEmpty())
                                return "ERROR";
                            double n1= (double)operand.pop();
                            if(operand.isEmpty())
                                return "ERROR";

                            double n2= (double)operand.pop();
                            if(operator.peek().equals("+")){
                                operand.push(add(n1,n2));
                                if(operator.isEmpty())
                                    return "ERROR";
                                operator.pop();
                            }
                            else if(operator.peek().equals("-")){
                                operand.push(sub(n2,n1));
                                if(operator.isEmpty())
                                    return "ERROR";
                                operator.pop();
                            }
                            else if(operator.peek().equals("*")){
                                operand.push(mul(n2,n1));
                                if(operator.isEmpty())
                                    return "ERROR";
                                operator.pop();
                            }
                            else if(operator.peek().equals("/")){
                                operand.push(div(n2,n1));
                                if(operator.isEmpty())
                                    return "ERROR";
                                operator.pop();
                            }
                        }
                    }
                    else if((pieces[i].equals("+")||pieces[i].equals("-"))&&(operator.peek().equals("*")||operator.peek().equals("/"))){
                        while(true){
                            if(operator.empty())
                                break;
                            if(operator.peek().equals("+")||operator.peek().equals("-")||operator.peek().equals("("))
                                break;
                            if(operand.isEmpty())
                                return "ERROR";
                            double n1= (double)operand.pop();
                            if(operand.isEmpty())
                                return "ERROR";
                            double n2= (double)operand.pop();
                            if(operator.peek().equals("*")){
                                if(operator.isEmpty())
                                    return "ERROR";
                                operator.pop();
                                operand.push(mul(n2,n1));
                            }
                            else if(operator.peek().equals("/")){
                                if(operator.isEmpty())
                                    return "ERROR";
                                operator.pop();
                                operand.push(div(n2,n1));
                            }
                        }
                        operator.push(pieces[i]);
                    }
                    else if((pieces[i].equals("+")||pieces[i].equals("-"))&&(operator.peek().equals("+")||operator.peek().equals("-"))){
                        Toast.makeText(getApplicationContext(),"iam here ",Toast.LENGTH_SHORT).show();
                        while (true){
                            if(operator.empty())
                                break;
                            if(operand.isEmpty())
                                return "ERROR";
                            double n1= (double)operand.pop();
                            //Toast.makeText(getApplicationContext(),"op1 poped ",Toast.LENGTH_SHORT).show();
                            if(operand.isEmpty())
                                return "ERROR";
                            double n2= (double)operand.pop();
                            //Toast.makeText(getApplicationContext(),"op2 popped ",Toast.LENGTH_SHORT).show();
                            if(operator.peek().equals("+")){
                              //  Toast.makeText(getApplicationContext(),"wrong path ",Toast.LENGTH_SHORT).show();
                                if(operator.isEmpty())
                                    return "ERROR";
                                operator.pop();
                                operand.push(add(n2,n1));
                            }
                            else if(operator.peek().equals("-")){
                          //      Toast.makeText(getApplicationContext(),"right path ",Toast.LENGTH_SHORT).show();
                                if(operator.isEmpty()){
                            //        Toast.makeText(getApplicationContext(),"a7aa ",Toast.LENGTH_SHORT).show();
                                    return "ERROR";
                                }

                                operator.pop();
                                operand.push(sub(n2,n1));
                            }

                        }
                        operator.push(pieces[i]);
                    }
                    else if((pieces[i].equals("*")||pieces[i].equals("/"))&&(operator.peek().equals("*")||operator.peek().equals("/"))){
                        //Toast.makeText(getApplicationContext(),"iam here ",Toast.LENGTH_SHORT).show();
                        while (true){
                            if(operator.empty())
                                break;
                            if(operand.isEmpty())
                                return "ERROR";
                            double n1= (double)operand.pop();
                            //Toast.makeText(getApplicationContext(),"op1 poped ",Toast.LENGTH_SHORT).show();
                            if(operand.isEmpty())
                                return "ERROR";
                            double n2= (double)operand.pop();
                            //Toast.makeText(getApplicationContext(),"op2 popped ",Toast.LENGTH_SHORT).show();
                            if(operator.peek().equals("*")){
                               // Toast.makeText(getApplicationContext(),"wrong path ",Toast.LENGTH_SHORT).show();
                                if(operator.isEmpty())
                                    return "ERROR";
                                operator.pop();
                                operand.push(mul(n2,n1));
                            }
                            else if(operator.peek().equals("/")){
                                //Toast.makeText(getApplicationContext(),"right path ",Toast.LENGTH_SHORT).show();
                                if(operator.isEmpty()){
                                  //  Toast.makeText(getApplicationContext(),"a7aa ",Toast.LENGTH_SHORT).show();
                                    return "ERROR";
                                }

                                operator.pop();
                                operand.push(div(n2,n1));
                            }

                        }
                        operator.push(pieces[i]);
                    }
                    else operator.push(pieces[i]);
                }
                else
                    operand.push(Double.valueOf(pieces[i]));
            }

            if(!operator.empty())
                while(true){
                    if(operator.empty())
                        break;
                    double n1=0,n2=0;
                    if(operand.isEmpty())
                        return "ERROR";
                    n1= (double)operand.pop();
                    if(operand.isEmpty())
                        return "ERROR";
                    n2= (double)operand.pop();
                    if(operator.peek().equals("+")){
                        operand.push(add(n1,n2));
                        if(operator.isEmpty())
                            return "ERROR";
                        operator.pop();
                    }
                    else if(operator.peek().equals("-")){
                        operand.push(sub(n2,n1));
                        if(operator.isEmpty())
                            return "ERROR";
                        operator.pop();
                    }
                    else if(operator.peek().equals("*")){
                        operand.push(mul(n2,n1));
                        if(operator.isEmpty())
                            return "ERROR";
                        operator.pop();
                    }
                    else if(operator.peek().equals("/")){
                        operand.push(div(n2,n1));
                        if(operator.isEmpty())
                            return "ERROR";
                        operator.pop();
                    }
                }
            if(operand.isEmpty())
                return "ERROR";
            double result = (double)operand.pop();
            String resultStr = result+"";

            return formatResult(resultStr,result);
        }
        private String formatResult(String resultStr,double result){
            if((resultStr.charAt(resultStr.length()-2)=='.'&&resultStr.charAt(resultStr.length()-1)=='0')||(resultStr.contains("E")))
                resultStr = String.format ("%.0f", result);
            else{
                int prec = 0;
                resultStr = String.format ("%.10f", result);
                for(int i=resultStr.length()-1;i>=0;i--)
                    if(resultStr.charAt(i)=='0')
                        prec++;
                    else break;
                resultStr = resultStr.substring(0,resultStr.length()-prec);
            }
            if(Double.isNaN(result))
                resultStr = "UNDEFINED";
            else if(result==Double.NEGATIVE_INFINITY)
                resultStr = "-INFINITY";
            else if(result==Double.POSITIVE_INFINITY)
                resultStr = "+INFINITY";
            return resultStr;
        }
    }

}