package sample.furniture.Adapter;

import sample.furniture.furniture.Table;
import sample.furniture.furniture.Bed;


    public class Adapter extends Bed {
        Table table;

        public Adapter(Table table){
            this.table = table;
        }
    }