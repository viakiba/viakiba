go install github.com/go-delve/delve/cmd/dlv@latest 
echo "command_init_env.sh: go install github.com/go-delve/delve/cmd/dlv@latest"
go install -v golang.org/x/tools/gopls@latest 
echo "command_init_env.sh: go install golang.org/x/tools/gopls@latest"
go get golang.org/x/tools/gopls@latest 
echo "command_init_env.sh: go get golang.org/x/tools/gopls@latest"
go install -v github.com/stamblerre/gocode@latest 
echo "command_init_env.sh: go install github.com/stamblerre/gocode@latest"
go install -v golang.org/x/tools/cmd/goimports@latest   
echo "command_init_env.sh: go install golang.org/x/tools/cmd/goimports@latest"
go install -v github.com/ramya-rao-a/go-outline@latest 
echo "command_init_env.sh: go install github.com/ramya-rao-a/go-outline@latest"
go install -v github.com/rogpeppe/godef@latest
echo "command_init_env.sh: go install github.com/rogpeppe/godef@latest"
go install -v honnef.co/go/tools/cmd/staticcheck@latest
echo "command_init_env.sh: go install honnef.co/go/tools/cmd/staticcheck@latest"