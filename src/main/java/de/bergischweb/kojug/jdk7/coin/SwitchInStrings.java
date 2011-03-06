/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bergischweb.kojug.jdk7.coin;

/**
 * @author Johannes Th&ouml;nes <johannes.thoenes@googlemail.com>
 */
public abstract class SwitchInStrings {

    public int[] randomize(String algorithm) {
        switch (algorithm) {
            case "complete":
                return completeRandomization();
            case "block":
                return blockRandoization();
            case "stratified-block":
                return stratifiedBlockRandomization();
            default:
                throw new UnsupportedOperationException();
        }
    }
    
    public int[] randomizeIf(String algorithm) {
        if(algorithm.equals("complete")){
            return completeRandomization();
        }else if(algorithm.equals("block")){
            return blockRandoization();
        }else if(algorithm.equals("stratified-block")){
            return stratifiedBlockRandomization();
        }else {
            throw new UnsupportedOperationException();
        }
    }

    protected abstract int[] completeRandomization();

    protected abstract int[] blockRandoization();

    protected abstract int[] stratifiedBlockRandomization();
}
