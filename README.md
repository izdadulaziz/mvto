
# mvto
#### mvto is a tool for change directory in terminal easily

# How to install

1. clone repository

```
git clone https://github.com/izdadulaziz/mvto.git
```

2. cd to folder
```
cd mvto
```

3. build (required java)
```
bash build.sh
```
### Paste this code in file .bashrc if use bash 
```
export MVTO_BIN=/path/to/folder/build/mvto

mvto(){
    local result
    result="$(java -cp $MVTO_BIN Main $@)"
    if [[ "$result" =~ ^/ ]]; then
        cd "$result"
    else
        echo "$result"
    fi


}

```

