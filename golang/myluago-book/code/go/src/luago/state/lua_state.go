package state

type luaState struct {
	stack *luaStack
}

func New() *luaState {
	return &luaState{newLuaStack(20)}
}
