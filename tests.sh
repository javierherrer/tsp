#!/usr/bin/bash
echo "Compilando..."
./compilar.sh


for prueba in ./pruebas/fb/*
do
	./tsp -fb "$prueba"
done
for prueba in ./pruebas/av/*
do
	./tsp -av "$prueba"
done
for prueba in ./pruebas/pd/*
do
	./tsp -pd "$prueba"
done
for prueba in ./pruebas/rp/*
do
	./tsp -rp "$prueba"
done
