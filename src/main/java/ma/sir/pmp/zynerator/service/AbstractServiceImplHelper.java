package ma.sir.pmp.zynerator.service;

import ma.sir.pmp.zynerator.util.ListUtil;

import java.util.ArrayList;
import java.util.List;


public class AbstractServiceImplHelper<T> {

    public List<List<T>>  getToBeSavedAndToBeDeleted(List<T> oldList,List<T> newList){
        List<List<T>> result= new ArrayList<>();
        List<T> resultDelete= new ArrayList<>();
        List<T> resultUpdateOrSave= new ArrayList<>();
        boolean oldEmpty = ListUtil.isEmpty(oldList);
        boolean newEmpty = ListUtil.isEmpty(newList);
        if (!newEmpty && oldEmpty){
            resultUpdateOrSave.addAll(newList);
        }else if (newEmpty &&  !oldEmpty){
            resultDelete.addAll(oldList);
        }else if(!newEmpty && !oldEmpty) {
            separateToDeleteAndToUpdate(oldList,newList,resultUpdateOrSave,resultDelete);
            populateSaveOrUpdate(oldList,newList,resultUpdateOrSave);
        }
        result.add(resultUpdateOrSave);
        result.add(resultDelete);
        return result;
    }


    private void populateSaveOrUpdate(List<T> oldList, List<T> newList,List<T> resultUpdateOrSave) {
        for (int i = 0; i <newList.size() ; i++) {
        T myNew = newList.get(i);
        T t = oldList.stream().filter(myNew::equals).findFirst().orElse(null);
            if(t==null){
                resultUpdateOrSave.add(myNew);
            }
        }
    }

    private void separateToDeleteAndToUpdate(List<T> oldList, List<T> newList,List<T> resultUpdateOrSave, List<T> resultDelete) {
        for (int i = 0; i <oldList.size() ; i++) {
        T myOld = oldList.get(i);
        T t = newList.stream().filter(myOld::equals).findFirst().orElse(null);
            if(t!=null){
                resultUpdateOrSave.add(t);
            }else{
                resultDelete.add(myOld);
            }
        }
    }

}
