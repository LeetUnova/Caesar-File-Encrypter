# Caesar-File-Encrypter
A simple file encrypter that takes a string password from the command line arguments and adds that to all bytes in a file to encrypt it.

## How to use

It is simple to use. Simply call `run.bat` or build and use `java -jar passwordencrypt.jar`. You then add the arguments at the end, starting with either `-e` for encrypt or `-d` for decrypt. The next argument is the password. You can then put in as many file names as you would like to encrypt. Files you encrypt will be given the extension `lenc` and the files you decrypt will be given the extension `ldec`.

`.\buildYrun.bat -e "password" test.txt test2.txt`
`.\run.bat -d "password" test.lenc test2.lenc`